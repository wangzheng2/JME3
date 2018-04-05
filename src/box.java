import com.jme3.app.SimpleApplication;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class box extends SimpleApplication {

    @Override
    public void simpleInitApp() {

        Box b = new Box(1, 1, 1); // 创建方块网格
        Geometry geom = new Geometry("Box", b); // 使用方块网格来创建一个几何体
        
        // 创建一个简单材质
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue); // 设置为蓝色
        
        geom.setMaterial(mat); // 应用此材质
        
        rootNode.attachChild(geom); // 将方块添加到场景图中，使你可以看到它。
    }

    public static void main(String[] args) {
        box game = new box();
        game.start();
    }

}