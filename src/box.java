import com.jme3.app.SimpleApplication;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class box extends SimpleApplication {

    @Override
    public void simpleInitApp() {

        Box b = new Box(1, 1, 1); // ������������
        Geometry geom = new Geometry("Box", b); // ʹ�÷�������������һ��������
        
        // ����һ���򵥲���
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue); // ����Ϊ��ɫ
        
        geom.setMaterial(mat); // Ӧ�ô˲���
        
        rootNode.attachChild(geom); // ��������ӵ�����ͼ�У�ʹ����Կ�������
    }

    public static void main(String[] args) {
        box game = new box();
        game.start();
    }

}