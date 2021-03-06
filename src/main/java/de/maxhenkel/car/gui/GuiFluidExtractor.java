package de.maxhenkel.car.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import de.maxhenkel.car.Main;
import de.maxhenkel.car.blocks.tileentity.TileEntityFluidExtractor;
import de.maxhenkel.corelib.inventory.ScreenBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraftforge.fluids.FluidStack;

public class GuiFluidExtractor extends ScreenBase<ContainerFluidExtractor> {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(Main.MODID, "textures/gui/gui_fluid_extractor.png");

    private PlayerInventory playerInv;
    private TileEntityFluidExtractor tile;

    public GuiFluidExtractor(ContainerFluidExtractor container, PlayerInventory player, ITextComponent title) {
        super(GUI_TEXTURE, container, player, title);
        this.playerInv = player;
        this.tile = container.getTile();

        xSize = 176;
        ySize = 139;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(matrixStack, mouseX, mouseY);

        // Title
        font.func_238422_b_(matrixStack, playerInv.getDisplayName().func_241878_f(), 8, this.ySize - 96 + 2, FONT_COLOR);
        font.func_238422_b_(matrixStack, tile.getDisplayName().func_241878_f(), 8, 6, FONT_COLOR);

        drawFilter(matrixStack);
    }

    private void drawFilter(MatrixStack matrixStack) {
        IFormattableTextComponent name;

        Fluid f = tile.getFilterFluid();

        if (f == null) {
            name = new StringTextComponent("-");
        } else {
            name = new StringTextComponent(new FluidStack(f, 1).getDisplayName().getString());
        }

        font.func_238422_b_(matrixStack, new TranslationTextComponent("filter.fluid", name.mergeStyle(TextFormatting.WHITE)).func_241878_f(), 46, 28, FONT_COLOR);
    }

}
