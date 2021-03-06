package de.maxhenkel.car.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import de.maxhenkel.car.Main;
import de.maxhenkel.car.blocks.tileentity.TileEntityCarWorkshop;
import de.maxhenkel.car.entity.car.base.EntityCarBase;
import de.maxhenkel.car.entity.car.base.EntityCarDamageBase;
import de.maxhenkel.car.net.MessageOpenCarWorkshopGui;
import de.maxhenkel.car.net.MessageRepairCar;
import de.maxhenkel.corelib.inventory.ScreenBase;
import de.maxhenkel.corelib.math.MathUtils;
import de.maxhenkel.tools.EntityTools;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.ArrayList;
import java.util.List;

public class GuiCarWorkshopRepair extends ScreenBase<ContainerCarWorkshopRepair> {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(Main.MODID, "textures/gui/gui_car_workshop_repair.png");

    private PlayerEntity player;
    private TileEntityCarWorkshop tile;

    private Button buttonBack;
    private Button buttonRepair;

    private EntityTools.CarRenderer carRenderer;

    public GuiCarWorkshopRepair(ContainerCarWorkshopRepair container, PlayerInventory playerInventory, ITextComponent title) {
        super(GUI_TEXTURE, container, playerInventory, title);
        this.player = container.getPlayer();
        this.tile = container.getTile();
        this.carRenderer = new EntityTools.CarRenderer();

        xSize = 176;
        ySize = 222;
    }

    @Override
    protected void init() {
        super.init();

        this.buttonRepair = addButton(new Button(guiLeft + xSize - 7 - 60, guiTop + 105, 60, 20, new TranslationTextComponent("button.car.repair_car"), button -> {
            if (tile.getWorld().isRemote) {
                Main.SIMPLE_CHANNEL.sendToServer(new MessageRepairCar(tile.getPos(), player));
            }
        }));
        this.buttonRepair.active = false;

        this.buttonBack = addButton(new Button(guiLeft + 7, guiTop + 105, 60, 20, new TranslationTextComponent("button.car.back"), button -> {
            if (tile.getWorld().isRemote) {
                Main.SIMPLE_CHANNEL.sendToServer(new MessageOpenCarWorkshopGui(tile.getPos(), player, false));
            }
        }));
        this.buttonBack.active = true;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(matrixStack, mouseX, mouseY);

        // Titles
        font.func_238422_b_(matrixStack, tile.getDisplayName().func_241878_f(), 8, 6, FONT_COLOR);
        font.func_238422_b_(matrixStack, player.inventory.getDisplayName().func_241878_f(), 8, ySize - 96 + 2, FONT_COLOR);

        EntityCarBase carTop = tile.getCarOnTop();

        if (!(carTop instanceof EntityCarDamageBase)) {
            buttonRepair.active = false;
            return;
        }

        EntityCarDamageBase car = (EntityCarDamageBase) carTop;

        if (mouseX >= guiLeft + 52 && mouseX <= guiLeft + 123) {
            if (mouseY >= guiTop + 81 && mouseY <= guiTop + 90) {
                List<IReorderingProcessor> list = new ArrayList<>();
                list.add(new TranslationTextComponent("tooltip.damage", MathUtils.round(car.getDamage(), 2)).func_241878_f());
                renderTooltip(matrixStack, list, mouseX - guiLeft, mouseY - guiTop);
            }
        }

        if (tile.areRepairItemsInside() && car.getDamage() > 0) {
            buttonRepair.active = true;
        } else {
            buttonRepair.active = false;
        }
        drawCar(matrixStack, carTop);
    }

    @Override
    public void tick() {
        super.tick();
        carRenderer.tick();
    }

    private void drawCar(MatrixStack matrixStack, EntityCarBase car) {
        carRenderer.render(matrixStack, car, xSize / 2, 55, 23);
    }

    public double getDamagePercent(EntityCarDamageBase car) {
        float dmg = car.getDamage();
        dmg = Math.min(dmg, 100);
        return MathUtils.round(dmg, 2);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        super.drawGuiContainerBackgroundLayer(matrixStack, partialTicks, mouseX, mouseY);
        drawDamage(matrixStack);
    }

    public void drawDamage(MatrixStack matrixStack) {
        EntityCarBase car = tile.getCarOnTop();
        if (!(car instanceof EntityCarDamageBase)) {
            return;
        }

        EntityCarDamageBase c = (EntityCarDamageBase) car;

        double percent = 100 - getDamagePercent(c);

        minecraft.getTextureManager().bindTexture(GUI_TEXTURE);
        int scaled = (int) (72 * percent / 100);
        int i = this.guiLeft;
        int j = this.guiTop;
        blit(matrixStack, i + 52, j + 81, 176, 0, scaled, 10);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

}