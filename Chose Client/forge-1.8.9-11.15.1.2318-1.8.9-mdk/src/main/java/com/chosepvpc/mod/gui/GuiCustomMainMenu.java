package com.chosepvpc.mod.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiCustomMainMenu extends GuiScreen {

    // Caminho da imagem: src/main/resources/assets/meuclient/textures/gui/menu_bg.png
    private final ResourceLocation backgroundLocation = new ResourceLocation("meuclient", "textures/gui/menu_bg.png");

    @Override
    public void initGui() {
        // Limpa botões antigos ao redimensionar a tela
        this.buttonList.clear();
        
        // Adiciona os botões no seu menu personalizado (ID, X, Y, Largura, Altura, Texto)
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 2 - 40, "Singleplayer"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 2 - 15, "Multiplayer"));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 100, this.height / 2 + 10, "Configurações"));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 100, this.height / 2 + 35, "Sair do Jogo"));
        
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // Renderiza a sua imagem de fundo customizada cobrindo a tela inteira
        this.mc.getTextureManager().bindTexture(backgroundLocation);
        drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);

        // Desenha o título do seu Client no topo
        this.drawCenteredString(this.fontRendererObj, "MEU PVP CLIENT", this.width / 2, this.height / 2 - 80, 0xFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case 1:
                this.mc.displayGuiScreen(new GuiSelectWorld(this));
                break;
            case 2:
                this.mc.displayGuiScreen(new GuiMultiplayer(this));
                break;
            case 3:
                this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
                break;
            case 4:
                this.mc.shutdown();
                break;
        }
        super.actionPerformed(button);
    }
}