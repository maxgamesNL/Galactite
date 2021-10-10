package me.maxmods.learnfabric.features.gui;
//totally didnt copy half of 0x's code: https://github.com/fartdev/Atomic/blob/master/src/main/java/me/zeroX150/atomic/feature/gui/ImGuiScreen.java
//0x's code didnt work. switched to :https://www.youtube.com/watch?v=6jmxwRMb-aY
//Imgui github: https://github.com/SpaiR/imgui-java/tree/v1.84.1.2
import imgui.ImGui;
import imgui.flag.ImGuiCol;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import me.maxmods.learnfabric.features.module.Category;
import me.maxmods.learnfabric.features.module.Module;
import me.maxmods.learnfabric.features.module.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import java.util.ArrayList;
import java.util.Objects;

public class TestGUI extends Screen {


    public static TestGUI INSTANCE;
    private final ImGuiImplGlfw implGlfw = new ImGuiImplGlfw();
    private final ImGuiImplGl3 implGl3 = new ImGuiImplGl3();
    private long windowPtr;
    int x = 25;

    public TestGUI() {
        super(Text.of(" "));
        windowPtr = MinecraftClient.getInstance().getWindow().getHandle();
        INSTANCE = this;
        ImGui.createContext();
        implGlfw.init(windowPtr, true);
        implGl3.init();



    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        //does the imGui stuff
        ImGui.getIO().setDisplaySize(MinecraftClient.getInstance().getWindow().getWidth(), MinecraftClient.getInstance().getWindow().getHeight());
        implGlfw.newFrame();
        ImGui.newFrame();
        x = 25;





        if(true){
            ImGui.getIO().setConfigWindowsMoveFromTitleBarOnly(true);
            ImGui.getStyle().setWindowMenuButtonPosition(-1);
            ImGui.getStyle().setColor(ImGuiCol.Button, 0, 0, 0, 127);
            ImGui.getStyle().setColor(ImGuiCol.Header, 50, 50, 50, 255);
            ImGui.getStyle().setColor(ImGuiCol.Border, 50, 50, 50, 255);
            ImGui.getStyle().setColor(ImGuiCol.ButtonHovered, 80, 80, 80, 255);
            ImGui.getStyle().setColor(ImGuiCol.TitleBg, 50, 50, 50, 255);
            ImGui.getStyle().setColor(ImGuiCol.CheckMark, 255, 255, 255, 255);
            ImGui.getStyle().setColor(ImGuiCol.SliderGrab, 255, 255, 255, 255);
            ImGui.getStyle().setColor(ImGuiCol.SliderGrabActive, 200, 200, 200, 255);
            ImGui.getStyle().setColor(ImGuiCol.FrameBgActive, 200, 200, 200, 255);
            ImGui.getStyle().setColor(ImGuiCol.ButtonActive, 100, 100, 100, 255);
            ImGui.getStyle().setColor(ImGuiCol.Header, 50, 50, 50, 255);
            ImGui.getStyle().setColor(ImGuiCol.HeaderHovered, 75, 75, 75, 255);
            ImGui.getStyle().setColor(ImGuiCol.Text, 255, 255, 255, 255);
            ImGui.getStyle().setColor(ImGuiCol.WindowBg, 25, 25, 25, 255);
            ImGui.getStyle().setColor(ImGuiCol.Border, 0, 0, 0, 255);
        }

        for (Category category : ModuleRegistry.getInstance().getCATEGORIES()) {
            ImGui.begin(category.getName());
            if (!category.isCatLoaded()){
                ImGui.setWindowPos(x, 50);
                x += 325;
                ImGui.setWindowSize(250, 450);
                category.SetCatLoaded(true);
            }
            ArrayList<Module> modulesByCategoryArray = new ArrayList<>();
            for (Module module: ModuleRegistry.getInstance().getAll()){
                if (module.getCategory().equals(category)){modulesByCategoryArray.add(module);}
            }
            for (Module module : modulesByCategoryArray){
                if (ImGui.collapsingHeader(module.isEnabled() ? module.getName() + " 0" : module.getName() + " X")){
                    ImGui.checkbox("Enable", module.isEnabled());
                    }

            }
            ImGui.end();

        }
        ImGui.render();
        implGl3.renderDrawData(Objects.requireNonNull(ImGui.getDrawData()));


        }




    public void onClose() {
        super.onClose();
    }
}