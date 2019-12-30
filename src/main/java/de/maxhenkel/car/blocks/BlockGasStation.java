package de.maxhenkel.car.blocks;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import de.maxhenkel.car.ModItemGroups;
import de.maxhenkel.car.blocks.tileentity.TileEntityGasStation;
import de.maxhenkel.car.gui.ContainerGasStation;
import de.maxhenkel.car.gui.ContainerGasStationAdmin;
import de.maxhenkel.car.gui.TileEntityContainerProvider;
import de.maxhenkel.tools.VoxelShapeTools;
import de.maxhenkel.tools.FluidUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;

public class BlockGasStation extends BlockOrientableHorizontal {

    public BlockGasStation() {
        super("gas_station", Material.IRON, MaterialColor.IRON, SoundType.METAL, 4F, 50F);
    }

    @Override
    public Item toItem() {
        return new BlockItem(this, new Item.Properties().group(ModItemGroups.TAB_CAR)) {
            @Override
            protected boolean canPlace(BlockItemUseContext context, BlockState state) {
                if (!context.getWorld().isAirBlock(context.getPos().up())) {
                    return false;
                }
                return super.canPlace(context, state);
            }
        }.setRegistryName(this.getRegistryName());
    }

    @Override
    public ActionResultType func_225533_a_(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        TileEntity te = worldIn.getTileEntity(pos);

        if (!(te instanceof TileEntityGasStation)) {
            return ActionResultType.FAIL;
        }


        TileEntityGasStation station = (TileEntityGasStation) te;

        ItemStack stack = player.getHeldItem(handIn);

        if (station.isOwner(player) || !station.hasTrade()) {
            if (stack != null) {
                FluidStack fluidStack = FluidUtil.getFluidContained(stack).orElse(FluidStack.EMPTY);

                if (!FluidUtils.isEmpty(fluidStack)) {
                    boolean success = BlockTank.handleEmpty(stack, worldIn, pos, player, handIn);
                    if (success) {
                        return ActionResultType.SUCCESS;
                    }
                }
                IFluidHandler handler = FluidUtil.getFluidHandler(stack).orElse(null);

                if (handler != null) {
                    boolean success1 = BlockTank.handleFill(stack, worldIn, pos, player, handIn);
                    if (success1) {
                        return ActionResultType.SUCCESS;
                    }
                }
            }
        }


        if (!player.func_225608_bj_()) {
            if (player instanceof ServerPlayerEntity) {
                TileEntityContainerProvider.openGui((ServerPlayerEntity) player, station, (i, playerInventory, playerEntity) -> new ContainerGasStation(i, station, playerInventory));
            }
            return ActionResultType.SUCCESS;
        } else if (station.isOwner(player)) {
            if (player instanceof ServerPlayerEntity) {
                TileEntityContainerProvider.openGui((ServerPlayerEntity) player, station, (i, playerInventory, playerEntity) -> new ContainerGasStationAdmin(i, station, playerInventory));
            }
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.FAIL;
    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return false;
    }

    public static VoxelShape SHAPE_NORTH_SOUTH = Block.makeCuboidShape(2D, 0D, 5D, 14D, 31D, 11D);
    public static VoxelShape SHAPE_NEAST_WEST = Block.makeCuboidShape(5D, 0D, 2D, 11D, 31D, 14D);
    public static VoxelShape SHAPE_SLAB = Block.makeCuboidShape(0D, 0D, 0D, 16D, 8.01D, 16D);

    private static final Map<Direction, VoxelShape> SHAPES = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH,
            VoxelShapeTools.combine(
                    SHAPE_NORTH_SOUTH,
                    SHAPE_SLAB
            ),
            Direction.SOUTH,
            VoxelShapeTools.combine(
                    SHAPE_NORTH_SOUTH,
                    SHAPE_SLAB
            ),
            Direction.EAST,
            VoxelShapeTools.combine(
                    SHAPE_NEAST_WEST,
                    SHAPE_SLAB
            ),
            Direction.WEST,
            VoxelShapeTools.combine(
                    SHAPE_NEAST_WEST,
                    SHAPE_SLAB
            )
    ));

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPES.get(state.get(FACING));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if (worldIn.isAirBlock(pos.up())) {
            worldIn.setBlockState(pos.up(), ModBlocks.FUEL_STATION_TOP.getDefaultState().with(ModBlocks.FUEL_STATION_TOP.FACING, state.get(FACING)));
        }

        TileEntity te = worldIn.getTileEntity(pos);

        if (te != null && te instanceof TileEntityGasStation && placer instanceof PlayerEntity) {
            TileEntityGasStation station = (TileEntityGasStation) te;
            station.setOwner((PlayerEntity) placer);
        }

        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        super.onReplaced(state, worldIn, pos, newState, isMoving);

        BlockState stateUp = worldIn.getBlockState(pos.up());
        if (stateUp != null && stateUp.getBlock() != null && stateUp.getBlock().equals(ModBlocks.FUEL_STATION_TOP)) {
            worldIn.destroyBlock(pos.up(), false);
        }

        dropItems(worldIn, pos);
    }

    public static void dropItems(World worldIn, BlockPos pos) {
        TileEntity te = worldIn.getTileEntity(pos);

        if (te != null && te instanceof TileEntityGasStation) {
            TileEntityGasStation station = (TileEntityGasStation) te;
            InventoryHelper.dropInventoryItems(worldIn, pos, station.getInventory());
            InventoryHelper.dropInventoryItems(worldIn, pos, station.getTradingInventory());
        }
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityGasStation();
    }
}