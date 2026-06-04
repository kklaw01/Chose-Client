package com.chosepvpc.mod;

import com.chosepvpc.mod.gui.GuiCustomMainMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MenuHandler {

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        // Se a tela que está tentando abrir for o Menu Principal padrão do Minecraft...
        if (event.gui instanceof GuiMainMenu) {
            // Substitui pela sua tela customizada
            event.gui = new GuiCustomMainMenu();
        }
    }
}