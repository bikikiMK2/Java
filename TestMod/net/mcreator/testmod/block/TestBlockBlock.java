/*    */ package net.mcreator.testmod.block;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import net.mcreator.testmod.TestmodModElements;
/*    */ import net.mcreator.testmod.TestmodModElements.ModElement.Tag;
/*    */ import net.minecraft.block.AbstractBlock;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockState;
/*    */ import net.minecraft.block.SoundType;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.item.BlockItem;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemGroup;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.loot.LootContext;
/*    */ import net.minecraft.util.IItemProvider;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IBlockReader;
/*    */ import net.minecraftforge.registries.ObjectHolder;
/*    */ 
/*    */ @Tag
/*    */ public class TestBlockBlock
/*    */   extends TestmodModElements.ModElement {
/*    */   @ObjectHolder("testmod:test_block")
/* 26 */   public static final Block block = null;
/*    */   
/*    */   public TestBlockBlock(TestmodModElements instance) {
/* 29 */     super(instance, 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void initElements() {
/* 34 */     this.elements.blocks.add(() -> new CustomBlock());
/* 35 */     this.elements.items
/* 36 */       .add(() -> (Item)(new BlockItem(block, (new Item.Properties()).func_200916_a(ItemGroup.field_78030_b))).setRegistryName(block.getRegistryName()));
/*    */   }
/*    */   
/*    */   public static class CustomBlock extends Block {
/*    */     public CustomBlock() {
/* 41 */       super(AbstractBlock.Properties.func_200945_a(Material.field_151576_e).func_200947_a(SoundType.field_185851_d).func_200948_a(1.0F, 10.0F).func_235838_a_(s -> 0));
/* 42 */       setRegistryName("test_block");
/*    */     }
/*    */ 
/*    */     
/*    */     public int func_200011_d(BlockState state, IBlockReader worldIn, BlockPos pos) {
/* 47 */       return 15;
/*    */     }
/*    */ 
/*    */     
/*    */     public List<ItemStack> func_220076_a(BlockState state, LootContext.Builder builder) {
/* 52 */       List<ItemStack> dropsOriginal = super.func_220076_a(state, builder);
/* 53 */       if (!dropsOriginal.isEmpty())
/* 54 */         return dropsOriginal; 
/* 55 */       return Collections.singletonList(new ItemStack((IItemProvider)this, 1));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\bikikiMK2\Desktop\testMod\TestMod-ver1.0.1.jar!\net\mcreator\testmod\block\TestBlockBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */