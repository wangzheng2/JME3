
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.debug.Arrow;
import com.jme3.scene.shape.Quad;
import com.jme3.texture.Texture;

public class Picture extends SimpleApplication {

    public static void main(String[] args) {
        // ������Ϸ
       Picture app = new Picture();
        app.start();
    }
    @Override
    public void simpleInitApp() {
        // ����X��Y��Z����ļ�ͷ����Ϊ�ο�����ϵ��
        createArrow(new Vector3f(5, 0, 0), ColorRGBA.Green);
        createArrow(new Vector3f(0, 5, 0), ColorRGBA.Red);
        createArrow(new Vector3f(0, 0, 5), ColorRGBA.Blue);
        // ���ء�ͼƬ��
        Spatial pic = getPicture();
        // ����ͼƬ����ӵ�����ͼ��
        rootNode.attachChild(pic);
    }
    /**
     * ����һ����ͼƬ��
     * 
     * @return
     */
    private Spatial getPicture() {
        // ����һ���ı���
        Quad quad = new Quad(4, 3);
        Geometry geom = new Geometry("Picture", quad);

        // ����ͼƬ
        Texture tex = assetManager.loadTexture("Interface/Gui/pic.jpg");

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setTexture("ColorMap", tex);

        // Ӧ���������
        geom.setMaterial(mat);

        return geom;
    }

    /**
     * ����һ����ͷ
     * 
     * @param vec3 ��ͷ����
     * @param color ��ͷ��ɫ
     */
    private void createArrow(Vector3f vec3, ColorRGBA color) {
        // �������ʣ��趨��ͷ����ɫ
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);

        // �����������壬Ӧ�ü�ͷ����
        Geometry geom = new Geometry("arrow", new Arrow(vec3));
        geom.setMaterial(mat);

        // ��ӵ�������
        rootNode.attachChild(geom);
    }

}