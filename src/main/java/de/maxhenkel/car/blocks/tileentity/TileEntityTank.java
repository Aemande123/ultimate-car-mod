package de.maxhenkel.car.blocks.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

public class TileEntityTank extends TileEntityBase implements IFluidHandler, ITickable {

	private FluidStack fluid;
	public static final int CAPACITY = 16000;

	public TileEntityTank() {
		this.fluid = null;
	}

	@Override
	public void update() {
		/*if (world.isRemote) {
			return;
		}*/

		if (fluid == null) {
			return;
		}

		checkDown();

		for (EnumFacing facing : EnumFacing.HORIZONTALS) {
			if (fluid == null) {
				return;
			}
			checkSide(facing);
		}

	}

	public void checkSide(EnumFacing side) {
		TileEntity te = worldObj.getTileEntity(pos.offset(side));

		if (!(te instanceof TileEntityTank)) {
			return;
		}

		TileEntityTank otherTank = (TileEntityTank) te;

		FluidStack other = otherTank.getFluid();

		if (other == null) {
			otherTank.setFluid(new FluidStack(fluid.getFluid(), 0));
			other = otherTank.getFluid();
		}

		if (!other.getFluid().equals(fluid.getFluid())) {
			return;
		}

		int dif = other.amount - fluid.amount;

		if (dif >= -2) {
			return;
		}

		FluidStack stack = FluidUtil.tryFluidTransfer(otherTank, this, (-dif) / 2, true);
	}

	public void checkDown() {
		TileEntity te = worldObj.getTileEntity(pos.down());

		if (!(te instanceof TileEntityTank)) {
			return;
		}

		TileEntityTank otherTank = (TileEntityTank) te;

		FluidStack stack = FluidUtil.tryFluidTransfer(otherTank, this, Integer.MAX_VALUE, true);

		if (stack == null) {
			return;
		}

		if (fluid != null && fluid.amount <= 0) {
			fluid = null;
		}
	}

	public float getFillPercent() {
		if (fluid == null) {
			return 0F;
		}

		return ((float) fluid.amount) / ((float) CAPACITY);
	}

	public FluidStack getFluid() {
		return fluid;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {

		if (fluid != null) {
			NBTTagCompound comp = new NBTTagCompound();

			fluid.writeToNBT(comp);

			compound.setTag("fluid", comp);
		}

		return super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		if (compound.hasKey("fluid")) {
			NBTTagCompound comp = compound.getCompoundTag("fluid");
			this.fluid = FluidStack.loadFluidStackFromNBT(comp);
		}
		super.readFromNBT(compound);
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(this.pos, 1, getUpdateTag());
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return this.writeToNBT(new NBTTagCompound());
	}

	@Override
	public IFluidTankProperties[] getTankProperties() {
		return new IFluidTankProperties[] { new IFluidTankProperties() {

			@Override
			public FluidStack getContents() {
				return fluid;
			}

			@Override
			public int getCapacity() {
				return CAPACITY;
			}

			@Override
			public boolean canFillFluidType(FluidStack fluidStack) {
				return true;
			}

			@Override
			public boolean canFill() {
				return true;
			}

			@Override
			public boolean canDrainFluidType(FluidStack fluidStack) {
				return true;
			}

			@Override
			public boolean canDrain() {
				return true;
			}
		} };
	}

	@Override
	public int fill(FluidStack resource, boolean doFill) {
		if (fluid == null) {
			int amount = Math.min(resource.amount, CAPACITY);

			if (doFill) {
				fluid = new FluidStack(resource.getFluid(), amount);
				//synchronize();
				markDirty();
			}

			return amount;
		} else if (resource.getFluid().equals(fluid.getFluid())) {
			int amount = Math.min(resource.amount, CAPACITY - fluid.amount);

			if (doFill) {
				fluid.amount += amount;
				//synchronize();
				markDirty();
			}

			return amount;
		}
		return 0;
	}

	@Override
	public FluidStack drain(FluidStack resource, boolean doDrain) {

		if (fluid == null) {
			return null;
		}

		if (fluid.getFluid().equals(resource.getFluid())) {
			int amount = Math.min(resource.amount, fluid.amount);

			Fluid f = fluid.getFluid();

			if (doDrain) {
				fluid.amount -= amount;
				if (fluid.amount <= 0) {
					fluid = null;
				}
				//synchronize();
				markDirty();
			}

			return new FluidStack(f, amount);
		}

		return null;
	}

	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		if (fluid == null) {
			return null;
		}

		int amount = Math.min(maxDrain, fluid.amount);

		Fluid f = fluid.getFluid();

		if (doDrain) {
			fluid.amount -= amount;
			if (fluid.amount <= 0) {
				fluid = null;
			}
			//synchronize();
			markDirty();
		}

		return new FluidStack(f, amount);
	}

	public void setFluid(FluidStack fluid) {
		this.fluid = fluid;
	}

}