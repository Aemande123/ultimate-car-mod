package de.maxhenkel.car.entity.model.wood;

import de.maxhenkel.car.entity.car.base.EntityCarBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWoodCar extends ModelBase {
	// fields
	private ModelRenderer haube;
	private ModelRenderer right;
	private ModelRenderer left;
	private ModelRenderer front;
	private ModelRenderer back;
	private ModelRenderer frontWindow;
	private ModelRenderer driverBack;
	private ModelRenderer leftTop;
	private ModelRenderer rightTop;
	private ModelRenderer bottom;
	private ModelRenderer rear;
	private ModelRenderer top;
	private ModelRenderer spoiler;
	private ModelRenderer sign;
	private ModelRenderer wheel1a;
	private ModelRenderer wheel1b;
	private ModelRenderer wheel1c;
	private ModelRenderer wheel1d;
	private ModelRenderer wheel1e;
	private ModelRenderer wheel1f;
	private ModelRenderer wheel1g;
	private ModelRenderer wheel2a;
	private ModelRenderer wheel2b;
	private ModelRenderer wheel2c;
	private ModelRenderer wheel2d;
	private ModelRenderer wheel2e;
	private ModelRenderer wheel2f;
	private ModelRenderer wheel2g;
	private ModelRenderer wheel3a;
	private ModelRenderer wheel3b;
	private ModelRenderer wheel3c;
	private ModelRenderer wheel3d;
	private ModelRenderer wheel3e;
	private ModelRenderer wheel3f;
	private ModelRenderer wheel3g;
	private ModelRenderer wheel4a;
	private ModelRenderer wheel4b;
	private ModelRenderer wheel4c;
	private ModelRenderer wheel4d;
	private ModelRenderer wheel4e;
	private ModelRenderer wheel4f;
	private ModelRenderer wheel4g;

	public ModelWoodCar() {
		textureWidth = 128;
		textureHeight = 256;

		haube = new ModelRenderer(this, 0, 74);
		haube.addBox(0F, 0F, 0F, 16, 1, 2);
		haube.setRotationPoint(-8F, 12F, 11F);
		haube.setTextureSize(128, 256);
		haube.mirror = true;
		setRotation(haube, 0F, 0F, 0F);
		right = new ModelRenderer(this, 0, 29);
		right.addBox(0F, 0F, 0F, 1, 8, 28);
		right.setRotationPoint(8F, 12F, -14F);
		right.setTextureSize(128, 256);
		right.mirror = true;
		setRotation(right, 0F, 0F, 0F);
		left = new ModelRenderer(this, 70, 29);
		left.addBox(0F, 0F, 0F, 1, 8, 28);
		left.setRotationPoint(-9F, 12F, -14F);
		left.setTextureSize(128, 256);
		left.mirror = true;
		setRotation(left, 0F, 0F, 0F);
		front = new ModelRenderer(this, 94, 65);
		front.addBox(0F, 0F, 0F, 16, 8, 1);
		front.setRotationPoint(-8F, 12F, 13F);
		front.setTextureSize(128, 256);
		front.mirror = true;
		setRotation(front, 0F, 0F, 0F);
		back = new ModelRenderer(this, 0, 65);
		back.addBox(0F, 0F, 0F, 16, 8, 1);
		back.setRotationPoint(-8F, 12F, -14F);
		back.setTextureSize(128, 256);
		back.mirror = true;
		setRotation(back, 0F, 0F, 0F);
		frontWindow = new ModelRenderer(this, 94, 114);
		frontWindow.addBox(0F, 0F, 0F, 16, 12, 1);
		frontWindow.setRotationPoint(-8F, 0F, 10F);
		frontWindow.setTextureSize(128, 256);
		frontWindow.mirror = true;
		setRotation(frontWindow, 0F, 0F, 0F);
		driverBack = new ModelRenderer(this, 0, 114);
		driverBack.addBox(0F, 0F, 0F, 16, 12, 1);
		driverBack.setRotationPoint(-8F, 0F, -6F);
		driverBack.setTextureSize(128, 256);
		driverBack.mirror = true;
		setRotation(driverBack, 0F, 0F, 0F);
		leftTop = new ModelRenderer(this, 92, 83);
		leftTop.addBox(0F, 0F, 0F, 1, 12, 17);
		leftTop.setRotationPoint(-9F, 0F, -6F);
		leftTop.setTextureSize(128, 256);
		leftTop.mirror = true;
		setRotation(leftTop, 0F, 0F, 0F);
		rightTop = new ModelRenderer(this, 0, 83);
		rightTop.addBox(0F, 0F, 0F, 1, 12, 17);
		rightTop.setRotationPoint(8F, 0F, -6F);
		rightTop.setTextureSize(128, 256);
		rightTop.mirror = true;
		setRotation(rightTop, 0F, 0F, 0F);
		bottom = new ModelRenderer(this, 0, 128);
		bottom.addBox(0F, 0F, 0F, 16, 1, 15);
		bottom.setRotationPoint(-8F, 0F, -5F);
		bottom.setTextureSize(128, 256);
		bottom.mirror = true;
		setRotation(bottom, 0F, 0F, 0F);
		rear = new ModelRenderer(this, 82, 74);
		rear.addBox(0F, 0F, 0F, 16, 1, 7);
		rear.setRotationPoint(-8F, 12F, -13F);
		rear.setTextureSize(128, 256);
		rear.mirror = true;
		setRotation(rear, 0F, 0F, 0F);
		top = new ModelRenderer(this, 36, 0);
		top.addBox(0F, 0F, 0F, 18, 1, 28);
		top.setRotationPoint(-9F, 20F, -14F);
		top.setTextureSize(128, 256);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);
		spoiler = new ModelRenderer(this, 94, 128);
		spoiler.addBox(0F, 0F, 0F, 16, 2, 1);
		spoiler.setRotationPoint(-8F, 18F, -15F);
		spoiler.setTextureSize(128, 256);
		spoiler.mirror = true;
		setRotation(spoiler, 0F, 0F, 0F);
		sign = new ModelRenderer(this, 54, 90);
		sign.addBox(0F, 0F, 0F, 10, 4, 1);
		sign.setRotationPoint(-5F, 15F, 14F);
		sign.setTextureSize(128, 256);
		sign.mirror = true;
		setRotation(sign, 0F, 0F, 0F);
		wheel1a = new ModelRenderer(this, 8, 2);
		wheel1a.addBox(0F, -3F, -2F, 1, 6, 1);
		wheel1a.setRotationPoint(9F, 20F, 8F);
		wheel1a.setTextureSize(128, 256);
		wheel1a.mirror = true;
		setRotation(wheel1a, 0F, 0F, 0F);
		wheel1b = new ModelRenderer(this, 12, 0);
		wheel1b.addBox(0F, -4F, -1F, 1, 8, 2);
		wheel1b.setRotationPoint(9F, 20F, 8F);
		wheel1b.setTextureSize(128, 256);
		wheel1b.mirror = true;
		setRotation(wheel1b, 0F, 0F, 0F);
		wheel1c = new ModelRenderer(this, 4, 3);
		wheel1c.addBox(0F, -2F, -3F, 1, 4, 1);
		wheel1c.setRotationPoint(9F, 20F, 8F);
		wheel1c.setTextureSize(128, 256);
		wheel1c.mirror = true;
		setRotation(wheel1c, 0F, 0F, 0F);
		wheel1d = new ModelRenderer(this, 0, 4);
		wheel1d.addBox(0F, -1F, -4F, 1, 2, 1);
		wheel1d.setRotationPoint(9F, 20F, 8F);
		wheel1d.setTextureSize(128, 256);
		wheel1d.mirror = true;
		setRotation(wheel1d, 0F, 0F, 0F);
		wheel1e = new ModelRenderer(this, 26, 4);
		wheel1e.addBox(0F, -1F, 3F, 1, 2, 1);
		wheel1e.setRotationPoint(9F, 20F, 8F);
		wheel1e.setTextureSize(128, 256);
		wheel1e.mirror = true;
		setRotation(wheel1e, 0F, 0F, 0F);
		wheel1f = new ModelRenderer(this, 22, 3);
		wheel1f.addBox(0F, -2F, 2F, 1, 4, 1);
		wheel1f.setRotationPoint(9F, 20F, 8F);
		wheel1f.setTextureSize(128, 256);
		wheel1f.mirror = true;
		setRotation(wheel1f, 0F, 0F, 0F);
		wheel1g = new ModelRenderer(this, 18, 2);
		wheel1g.addBox(0F, -3F, 1F, 1, 6, 1);
		wheel1g.setRotationPoint(9F, 20F, 8F);
		wheel1g.setTextureSize(128, 256);
		wheel1g.mirror = true;
		setRotation(wheel1g, 0F, 0F, 0F);
		wheel2a = new ModelRenderer(this, 18, 2);
		wheel2a.addBox(0F, -3F, 1F, 1, 6, 1);
		wheel2a.setRotationPoint(-10F, 20F, 8F);
		wheel2a.setTextureSize(128, 256);
		wheel2a.mirror = true;
		setRotation(wheel2a, 0F, 0F, 0F);
		wheel2b = new ModelRenderer(this, 12, 0);
		wheel2b.addBox(0F, -4F, -1F, 1, 8, 2);
		wheel2b.setRotationPoint(-10F, 20F, 8F);
		wheel2b.setTextureSize(128, 256);
		wheel2b.mirror = true;
		setRotation(wheel2b, 0F, 0F, 0F);
		wheel2c = new ModelRenderer(this, 22, 3);
		wheel2c.addBox(0F, -2F, 2F, 1, 4, 1);
		wheel2c.setRotationPoint(-10F, 20F, 8F);
		wheel2c.setTextureSize(128, 256);
		wheel2c.mirror = true;
		setRotation(wheel2c, 0F, 0F, 0F);
		wheel2d = new ModelRenderer(this, 0, 4);
		wheel2d.addBox(0F, -1F, -4F, 1, 2, 1);
		wheel2d.setRotationPoint(-10F, 20F, 8F);
		wheel2d.setTextureSize(128, 256);
		wheel2d.mirror = true;
		setRotation(wheel2d, 0F, 0F, 0F);
		wheel2e = new ModelRenderer(this, 26, 4);
		wheel2e.addBox(0F, -1F, 3F, 1, 2, 1);
		wheel2e.setRotationPoint(-10F, 20F, 8F);
		wheel2e.setTextureSize(128, 256);
		wheel2e.mirror = true;
		setRotation(wheel2e, 0F, 0F, 0F);
		wheel2f = new ModelRenderer(this, 4, 3);
		wheel2f.addBox(0F, -2F, -3F, 1, 4, 1);
		wheel2f.setRotationPoint(-10F, 20F, 8F);
		wheel2f.setTextureSize(128, 256);
		wheel2f.mirror = true;
		setRotation(wheel2f, 0F, 0F, 0F);
		wheel2g = new ModelRenderer(this, 8, 2);
		wheel2g.addBox(0F, -3F, -2F, 1, 6, 1);
		wheel2g.setRotationPoint(-10F, 20F, 8F);
		wheel2g.setTextureSize(128, 256);
		wheel2g.mirror = true;
		setRotation(wheel2g, 0F, 0F, 0F);
		wheel3a = new ModelRenderer(this, 26, 4);
		wheel3a.addBox(0F, -1F, 3F, 1, 2, 1);
		wheel3a.setRotationPoint(9F, 20F, -8F);
		wheel3a.setTextureSize(128, 256);
		wheel3a.mirror = true;
		setRotation(wheel3a, 0F, 0F, 0F);
		wheel3b = new ModelRenderer(this, 4, 3);
		wheel3b.addBox(0F, -2F, 2F, 1, 4, 1);
		wheel3b.setRotationPoint(9F, 20F, -8F);
		wheel3b.setTextureSize(128, 256);
		wheel3b.mirror = true;
		setRotation(wheel3b, 0F, 0F, 0F);
		wheel3c = new ModelRenderer(this, 18, 2);
		wheel3c.addBox(0F, -3F, 1F, 1, 6, 1);
		wheel3c.setRotationPoint(9F, 20F, -8F);
		wheel3c.setTextureSize(128, 256);
		wheel3c.mirror = true;
		setRotation(wheel3c, 0F, 0F, 0F);
		wheel3d = new ModelRenderer(this, 12, 0);
		wheel3d.addBox(0F, -4F, -1F, 1, 8, 2);
		wheel3d.setRotationPoint(9F, 20F, -8F);
		wheel3d.setTextureSize(128, 256);
		wheel3d.mirror = true;
		setRotation(wheel3d, 0F, 0F, 0F);
		wheel3e = new ModelRenderer(this, 18, 2);
		wheel3e.addBox(0F, -3F, -2F, 1, 6, 1);
		wheel3e.setRotationPoint(9F, 20F, -8F);
		wheel3e.setTextureSize(128, 256);
		wheel3e.mirror = true;
		setRotation(wheel3e, 0F, 0F, 0F);
		wheel3f = new ModelRenderer(this, 4, 3);
		wheel3f.addBox(0F, -2F, -3F, 1, 4, 1);
		wheel3f.setRotationPoint(9F, 20F, -8F);
		wheel3f.setTextureSize(128, 256);
		wheel3f.mirror = true;
		setRotation(wheel3f, 0F, 0F, 0F);
		wheel3g = new ModelRenderer(this, 26, 4);
		wheel3g.addBox(0F, -1F, -4F, 1, 2, 1);
		wheel3g.setRotationPoint(9F, 20F, -8F);
		wheel3g.setTextureSize(128, 256);
		wheel3g.mirror = true;
		setRotation(wheel3g, 0F, 0F, 0F);
		wheel4a = new ModelRenderer(this, 26, 4);
		wheel4a.addBox(0F, -1F, 3F, 1, 2, 1);
		wheel4a.setRotationPoint(-10F, 20F, -8F);
		wheel4a.setTextureSize(128, 256);
		wheel4a.mirror = true;
		setRotation(wheel4a, 0F, 0F, 0F);
		wheel4b = new ModelRenderer(this, 22, 3);
		wheel4b.addBox(0F, -2F, 2F, 1, 4, 1);
		wheel4b.setRotationPoint(-10F, 20F, -8F);
		wheel4b.setTextureSize(128, 256);
		wheel4b.mirror = true;
		setRotation(wheel4b, 0F, 0F, 0F);
		wheel4c = new ModelRenderer(this, 8, 2);
		wheel4c.addBox(0F, -3F, 1F, 1, 6, 1);
		wheel4c.setRotationPoint(-10F, 20F, -8F);
		wheel4c.setTextureSize(128, 256);
		wheel4c.mirror = true;
		setRotation(wheel4c, 0F, 0F, 0F);
		wheel4d = new ModelRenderer(this, 12, 0);
		wheel4d.addBox(0F, -4F, -1F, 1, 8, 2);
		wheel4d.setRotationPoint(-10F, 20F, -8F);
		wheel4d.setTextureSize(128, 256);
		wheel4d.mirror = true;
		setRotation(wheel4d, 0F, 0F, 0F);
		wheel4e = new ModelRenderer(this, 8, 2);
		wheel4e.addBox(0F, -3F, -2F, 1, 6, 1);
		wheel4e.setRotationPoint(-10F, 20F, -8F);
		wheel4e.setTextureSize(128, 256);
		wheel4e.mirror = true;
		setRotation(wheel4e, 0F, 0F, 0F);
		wheel4f = new ModelRenderer(this, 22, 3);
		wheel4f.addBox(0F, -2F, -3F, 1, 4, 1);
		wheel4f.setRotationPoint(-10F, 20F, -8F);
		wheel4f.setTextureSize(128, 256);
		wheel4f.mirror = true;
		setRotation(wheel4f, 0F, 0F, 0F);
		wheel4g = new ModelRenderer(this, 0, 4);
		wheel4g.addBox(0F, -1F, -4F, 1, 2, 1);
		wheel4g.setRotationPoint(-10F, 20F, -8F);
		wheel4g.setTextureSize(128, 256);
		wheel4g.mirror = true;
		setRotation(wheel4g, 0F, 0F, 0F);
	}
	
	public void setWheelRotation(float rot){
		setRotation(wheel1a, rot, 0F, 0F);
		setRotation(wheel1b, rot, 0F, 0F);
		setRotation(wheel1c, rot, 0F, 0F);
		setRotation(wheel1d, rot, 0F, 0F);
		setRotation(wheel1e, rot, 0F, 0F);
		setRotation(wheel1f, rot, 0F, 0F);
		setRotation(wheel1g, rot, 0F, 0F);
		setRotation(wheel2a, rot, 0F, 0F);
		setRotation(wheel2b, rot, 0F, 0F);
		setRotation(wheel2c, rot, 0F, 0F);
		setRotation(wheel2d, rot, 0F, 0F);
		setRotation(wheel2e, rot, 0F, 0F);
		setRotation(wheel2f, rot, 0F, 0F);
		setRotation(wheel2g, rot, 0F, 0F);
		setRotation(wheel3a, rot, 0F, 0F);
		setRotation(wheel3b, rot, 0F, 0F);
		setRotation(wheel3c, rot, 0F, 0F);
		setRotation(wheel3d, rot, 0F, 0F);
		setRotation(wheel3e, rot, 0F, 0F);
		setRotation(wheel3f, rot, 0F, 0F);
		setRotation(wheel3g, rot, 0F, 0F);
		setRotation(wheel4a, rot, 0F, 0F);
		setRotation(wheel4b, rot, 0F, 0F);
		setRotation(wheel4c, rot, 0F, 0F);
		setRotation(wheel4d, rot, 0F, 0F);
		setRotation(wheel4e, rot, 0F, 0F);
		setRotation(wheel4f, rot, 0F, 0F);
		setRotation(wheel4g, rot, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		
		EntityCarBase car=(EntityCarBase) entity;
		
		setWheelRotation(car.updateWheelRotation(f5));
		
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		haube.render(f5);
		right.render(f5);
		left.render(f5);
		front.render(f5);
		back.render(f5);
		frontWindow.render(f5);
		driverBack.render(f5);
		leftTop.render(f5);
		rightTop.render(f5);
		bottom.render(f5);
		rear.render(f5);
		top.render(f5);
		spoiler.render(f5);
		sign.render(f5);
		wheel1a.render(f5);
		wheel1b.render(f5);
		wheel1c.render(f5);
		wheel1d.render(f5);
		wheel1e.render(f5);
		wheel1f.render(f5);
		wheel1g.render(f5);
		wheel2a.render(f5);
		wheel2b.render(f5);
		wheel2c.render(f5);
		wheel2d.render(f5);
		wheel2e.render(f5);
		wheel2f.render(f5);
		wheel2g.render(f5);
		wheel3a.render(f5);
		wheel3b.render(f5);
		wheel3c.render(f5);
		wheel3d.render(f5);
		wheel3e.render(f5);
		wheel3f.render(f5);
		wheel3g.render(f5);
		wheel4a.render(f5);
		wheel4b.render(f5);
		wheel4c.render(f5);
		wheel4d.render(f5);
		wheel4e.render(f5);
		wheel4f.render(f5);
		wheel4g.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}