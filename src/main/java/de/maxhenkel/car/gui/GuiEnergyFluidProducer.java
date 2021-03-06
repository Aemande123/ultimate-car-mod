package de.maxhenkel.car.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import de.maxhenkel.car.blocks.tileentity.TileEntityEnergyFluidProducer;
import de.maxhenkel.corelib.inventory.ScreenBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class GuiEnergyFluidProducer<T extends ContainerEnergyFluidProducer> extends ScreenBase<T> {

    private PlayerInventory playerInv;
    private TileEntityEnergyFluidProducer tile;

    public GuiEnergyFluidProducer(ResourceLocation texture, T container, PlayerInventory playerInventory, ITextComponent title) {
        super(texture, container, playerInventory, title);
        this.playerInv = playerInventory;
        this.tile = container.getTile();

        xSize = 176;
        ySize = 166;
    }

    public String getUnlocalizedTooltipEnergy() {
        return "tooltip.energy";
    }

    public String getUnlocalizedTooltipProgress() {
        return "tooltip.progress";
    }

    public abstract String getUnlocalizedTooltipLiquid();

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(matrixStack, mouseX, mouseY);

        // Titles
        font.func_238422_b_(matrixStack, getTitle().func_241878_f(), 38, 6, FONT_COLOR);
        font.func_238422_b_(matrixStack, playerInv.getDisplayName().func_241878_f(), 8, this.ySize - 96 + 2, FONT_COLOR);

        if (mouseX >= guiLeft + 11 && mouseX <= guiLeft + 16 + 11) {
            if (mouseY >= guiTop + 8 && mouseY <= guiTop + 57 + 8) {
                List<IReorderingProcessor> list = new ArrayList<>();
                list.add(new TranslationTextComponent(getUnlocalizedTooltipEnergy(), tile.getStoredEnergy()).func_241878_f());
                renderTooltip(matrixStack, list, mouseX - guiLeft, mouseY - guiTop);
            }
        }

        if (mouseX >= guiLeft + 148 && mouseX <= guiLeft + 16 + 148) {
            if (mouseY >= guiTop + 8 && mouseY <= guiTop + 57 + 8) {
                List<IReorderingProcessor> list = new ArrayList<>();
                list.add(new TranslationTextComponent(getUnlocalizedTooltipLiquid(), tile.getCurrentMillibuckets()).func_241878_f());
                renderTooltip(matrixStack, list, mouseX - guiLeft, mouseY - guiTop);
            }
        }

        if (mouseX >= guiLeft + 79 && mouseX <= guiLeft + 24 + 79) {
            if (mouseY >= guiTop + 34 && mouseY <= guiTop + 17 + 34) {
                List<IReorderingProcessor> list = new ArrayList<>();
                list.add(new TranslationTextComponent(getUnlocalizedTooltipProgress(), ((int) (getProgress() * 100F))).func_241878_f());
                renderTooltip(matrixStack, list, mouseX - guiLeft, mouseY - guiTop);
            }
        }
    }

    public void drawEnergy(MatrixStack matrixStack) {
        float perc = getEnergy();

        int texX = 176;
        int texY = 17;
        int texW = 16;
        int texH = 57;
        int targetX = 11;
        int targetY = 8;

        int scHeight = (int) (texH * (1F - perc));
        int i = this.guiLeft;
        int j = this.guiTop;
        blit(matrixStack, i + targetX, j + targetY + scHeight, texX, texY + scHeight, texW, texH - scHeight);
    }

    public void drawFluid(MatrixStack matrixStack) {
        float perc = getFluid();

        int texX = 192;
        int texY = 17;
        int texW = 16;
        int texH = 57;
        int targetX = 148;
        int targetY = 8;

        int scHeight = (int) (texH * (1F - perc));
        int i = this.guiLeft;
        int j = this.guiTop;
        blit(matrixStack, i + targetX, j + targetY + scHeight, texX, texY + scHeight, texW, texH - scHeight);
    }

    public void drawProgress(MatrixStack matrixStack) {
        float perc = getProgress();

        int texX = 176;
        int texY = 0;
        int texW = 24;
        int texH = 17;
        int targetX = 79;
        int targetY = 34;

        int scWidth = (int) (texW * perc);
        int i = this.guiLeft;
        int j = this.guiTop;
        blit(matrixStack, i + targetX, j + targetY, texX, texY, scWidth, texH);
    }

    public float getEnergy() {
        return ((float) tile.getStoredEnergy()) / ((float) tile.getMaxEnergy());
    }

    public float getFluid() {
        return ((float) tile.getCurrentMillibuckets()) / ((float) tile.getFluidAmount());
    }

    public float getProgress() {
        if (tile.getTimeToGenerate() == 0) {
            return 0F;
        }
        return ((float) tile.getGeneratingTime()) / ((float) tile.getTimeToGenerate());
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        super.drawGuiContainerBackgroundLayer(matrixStack, partialTicks, mouseX, mouseY);
        drawEnergy(matrixStack);
        drawFluid(matrixStack);
        drawProgress(matrixStack);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

}
