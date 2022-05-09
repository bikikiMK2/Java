/*    */ package net.mcreator.testmod.procedures;
/*    */ 
/*    */ import java.util.Map;
/*    */ import net.mcreator.testmod.TestmodMod;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TestSwordLivingEntityIsHitWithToolProcedure
/*    */ {
/*    */   public static void executeProcedure(Map<String, Object> dependencies) {
/* 12 */     if (dependencies.get("entity") == null) {
/* 13 */       if (!dependencies.containsKey("entity"))
/* 14 */         TestmodMod.LOGGER.warn("Failed to load dependency entity for procedure TestSwordLivingEntityIsHitWithTool!"); 
/*    */       return;
/*    */     } 
/* 17 */     Entity entity = (Entity)dependencies.get("entity");
/* 18 */     entity.func_70015_d(8);
/*    */   }
/*    */ }


/* Location:              C:\Users\bikikiMK2\Desktop\testMod\TestMod-ver1.0.1.jar!\net\mcreator\testmod\procedures\TestSwordLivingEntityIsHitWithToolProcedure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */