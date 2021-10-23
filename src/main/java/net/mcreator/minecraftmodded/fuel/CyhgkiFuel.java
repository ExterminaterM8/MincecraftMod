
package net.mcreator.minecraftmodded.fuel;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.block.Blocks;

@Mod.EventBusSubscriber
public class CyhgkiFuel {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == Blocks.DARK_OAK_WOOD.asItem())
			event.setBurnTime(1600);
	}
}
