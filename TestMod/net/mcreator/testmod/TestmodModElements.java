/*     */ package net.mcreator.testmod;
/*     */ 
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.entity.EntityType;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.SoundEvent;
/*     */ import net.minecraftforge.api.distmarker.Dist;
/*     */ import net.minecraftforge.api.distmarker.OnlyIn;
/*     */ import net.minecraftforge.event.RegistryEvent;
/*     */ import net.minecraftforge.fml.ModList;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*     */ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
/*     */ import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
/*     */ import net.minecraftforge.fml.network.NetworkEvent;
/*     */ import net.minecraftforge.forgespi.language.ModFileScanData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TestmodModElements
/*     */ {
/*  41 */   public final List<ModElement> elements = new ArrayList<>();
/*  42 */   public final List<Supplier<Block>> blocks = new ArrayList<>();
/*  43 */   public final List<Supplier<Item>> items = new ArrayList<>();
/*  44 */   public final List<Supplier<EntityType<?>>> entities = new ArrayList<>();
/*  45 */   public final List<Supplier<Enchantment>> enchantments = new ArrayList<>();
/*  46 */   public static Map<ResourceLocation, SoundEvent> sounds = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int messageID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
/*  67 */     for (Map.Entry<ResourceLocation, SoundEvent> sound : sounds.entrySet())
/*  68 */       event.getRegistry().register(((SoundEvent)sound.getValue()).setRegistryName(sound.getKey())); 
/*     */   }
/*     */   
/*  71 */   public TestmodModElements() { this.messageID = 0; try { ModFileScanData modFileInfo = ModList.get().getModFileById("testmod").getFile().getScanResult(); Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations(); for (ModFileScanData.AnnotationData annotationData : annotations) { if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) { Class<?> clazz = Class.forName(annotationData.getClassType().getClassName()); if (clazz.getSuperclass() == ModElement.class)
/*     */             this.elements.add(clazz.getConstructor(new Class[] { getClass() }).newInstance(new Object[] { this }));  }  }
/*     */        }
/*     */     catch (Exception e) { e.printStackTrace(); }
/*  75 */      Collections.sort(this.elements); this.elements.forEach(ModElement::initElements); } public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) { TestmodMod.PACKET_HANDLER.registerMessage(this.messageID, messageType, encoder, decoder, messageConsumer);
/*  76 */     this.messageID++; }
/*     */ 
/*     */   
/*     */   public List<ModElement> getElements() {
/*  80 */     return this.elements;
/*     */   }
/*     */   
/*     */   public List<Supplier<Block>> getBlocks() {
/*  84 */     return this.blocks;
/*     */   }
/*     */   
/*     */   public List<Supplier<Item>> getItems() {
/*  88 */     return this.items;
/*     */   }
/*     */   
/*     */   public List<Supplier<EntityType<?>>> getEntities() {
/*  92 */     return this.entities;
/*     */   }
/*     */   
/*     */   public List<Supplier<Enchantment>> getEnchantments() {
/*  96 */     return this.enchantments;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ModElement
/*     */     implements Comparable<ModElement>
/*     */   {
/*     */     protected final TestmodModElements elements;
/*     */     
/*     */     protected final int sortid;
/*     */     
/*     */     public ModElement(TestmodModElements elements, int sortid) {
/* 108 */       this.elements = elements;
/* 109 */       this.sortid = sortid;
/*     */     }
/*     */ 
/*     */     
/*     */     public void initElements() {}
/*     */ 
/*     */     
/*     */     public void init(FMLCommonSetupEvent event) {}
/*     */ 
/*     */     
/*     */     public void serverLoad(FMLServerStartingEvent event) {}
/*     */ 
/*     */     
/*     */     @OnlyIn(Dist.CLIENT)
/*     */     public void clientLoad(FMLClientSetupEvent event) {}
/*     */ 
/*     */     
/*     */     public int compareTo(ModElement other) {
/* 127 */       return this.sortid - other.sortid;
/*     */     }
/*     */     
/*     */     @Retention(RetentionPolicy.RUNTIME)
/*     */     public static @interface Tag {}
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface Tag {}
/*     */ }


/* Location:              C:\Users\bikikiMK2\Desktop\testMod\TestMod-ver1.0.1.jar!\net\mcreator\testmod\TestmodModElements.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */