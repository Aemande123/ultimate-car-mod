package de.maxhenkel.car;

import de.maxhenkel.car.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION, acceptedMinecraftVersions=Main.MC_VERSION, updateJSON=Main.UPDATE_JSON, dependencies=Main.DEPENDENCIES)
public class Main{
	
    public static final String MODID = "car";
    public static final String VERSION = "1.2.11";
    public static final String MC_VERSION = "[1.12.2]";
	public static final String UPDATE_JSON = "http://maxhenkel.de/update/car.json";
	public static final String DEPENDENCIES = "required-after:forge@[14.23.2.2611,);required-after:redstoneflux;after:dynamiclights;after:crafttweaker;";

	@Instance
    private static Main instance;

	@SidedProxy(clientSide="de.maxhenkel.car.proxy.ClientProxy", serverSide="de.maxhenkel.car.proxy.CommonProxy")
    public static CommonProxy proxy;
    
	public Main() {
		instance=this;
	}
	
    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
		proxy.preinit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	 proxy.init(event);
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
		proxy.postinit(event);
    }
    
	public static Main instance() {
		return instance;
	}
	
}
