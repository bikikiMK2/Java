/*    */ package net.mcreator.testmod.item;
/*    */ 
/*    */ import java.util.AbstractMap;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.function.Supplier;
/*    */ import java.util.stream.Stream;
/*    */ import net.mcreator.testmod.TestmodModElements;
/*    */ import net.mcreator.testmod.TestmodModElements.ModElement.Tag;
/*    */ import net.mcreator.testmod.procedures.TestSwordLivingEntityIsHitWithToolProcedure;
/*    */ import net.minecraft.block.Blocks;
/*    */ import net.minecraft.entity.LivingEntity;
/*    */ import net.minecraft.item.IItemTier;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemGroup;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.SwordItem;
/*    */ import net.minecraft.item.crafting.Ingredient;
/*    */ import net.minecraft.util.IItemProvider;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.registries.ObjectHolder;
/*    */ 
/*    */ @Tag
/*    */ public class TestSwordItem
/*    */   extends TestmodModElements.ModElement {
/*    */   @ObjectHolder("testmod:test_sword")
/* 27 */   public static final Item block = null;
/*    */   
/*    */   public TestSwordItem(TestmodModElements instance) {
/* 30 */     super(instance, 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public void initElements() {
/* 35 */     this.elements.items.add(() -> (Item)(new SwordItem(new IItemTier() {
/*    */             public int func_200926_a() {
/* 37 */               return 114514;
/*    */             }
/*    */             
/*    */             public float func_200928_b() {
/* 41 */               return 0.0F;
/*    */             }
/*    */             
/*    */             public float func_200929_c() {
/* 45 */               return 6.0F;
/*    */             }
/*    */             
/*    */             public int func_200925_d() {
/* 49 */               return 0;
/*    */             }
/*    */             
/*    */             public int func_200927_e() {
/* 53 */               return 4;
/*    */             }
/*    */             
/*    */             public Ingredient func_200924_f() {
/* 57 */               return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)Blocks.field_150464_aj) }, );
/*    */             }
/*    */           },  3, -3.5F, (new Item.Properties()).func_200916_a(ItemGroup.field_78037_j))
/*    */         {
/*    */           public boolean func_77644_a(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
/* 62 */             boolean retval = super.func_77644_a(itemstack, entity, sourceentity);
/* 63 */             double x = entity.func_226277_ct_();
/* 64 */             double y = entity.func_226278_cu_();
/* 65 */             double z = entity.func_226281_cx_();
/* 66 */             World world = entity.field_70170_p;
/*    */             
/* 68 */             TestSwordLivingEntityIsHitWithToolProcedure.executeProcedure((Map)Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
/* 69 */                 .collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
/* 70 */             return retval;
/*    */           }
/*    */         }).setRegistryName("test_sword"));
/*    */   }
/*    */ }


/* Location:              C:\Users\bikikiMK2\Desktop\testMod\TestMod-ver1.0.1.jar!\net\mcreator\testmod\item\TestSwordItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */