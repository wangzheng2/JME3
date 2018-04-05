import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Sphere;

/**
 * ����ͼ���ڵ�
 */
public class binarystar extends SimpleApplication {
	private Spatial spatial;
	

	@Override
	public void simpleUpdate(float tpf) {
		// TODO Auto-generated method stub
		if (spatial != null) {
			// ��Y����ת
			spatial.rotate(0, 3.1415926f * tpf, 0);
		}
	}

	@Override
	public void simpleInitApp() {
		
		// ��������
		Mesh mesh = new Sphere(16, 24, 1);
		
		// ����2������
		Geometry geomA = new Geometry("��ɫ����", mesh);
		geomA.setMaterial(newLightingMaterial(ColorRGBA.Blue));
		
		Geometry geomB = new Geometry("��ɫ����", mesh);
		geomB.setMaterial(newLightingMaterial(ColorRGBA.Yellow));
		
		// ������������ӵ�һ��Node�ڵ���
		Node node = new Node("ԭ��");
		node.attachChild(geomA);
		node.attachChild(geomB);
		
		// ����������������λ��
		geomA.setLocalTranslation(-1, 3, 0);
		geomB.setLocalTranslation(1.5f, 2, 0);
		
		// ������ڵ���ӵ�����ͼ��
		rootNode.attachChild(node);
		
		// ��ӹ�Դ
		addLight();
		this.spatial = node;
	}
	
	/**
	 * ����һ���й����
	 * @param color
	 * @return
	 */
	private Material newLightingMaterial(ColorRGBA color) {
		// ��������
		Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
		
		mat.setColor("Diffuse", color);
		mat.setColor("Ambient", color);
		mat.setColor("Specular", ColorRGBA.White);
        mat.setFloat("Shininess", 24);
        mat.setBoolean("UseMaterialColors", true);
        
		return mat;
	}
	
    /**
     * ��ӹ�Դ
     */
    private void addLight() {
        // �����
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-1, -2, -3));

        // ������
        AmbientLight ambient = new AmbientLight();

        // ������������
        ColorRGBA lightColor = new ColorRGBA();
        sun.setColor(lightColor.mult(0.8f));
        ambient.setColor(lightColor.mult(0.2f));
        
        // #3 ��ģ�ͺ͹�Դ��ӵ�����ͼ��
        rootNode.addLight(sun);
        rootNode.addLight(ambient);
    }

	public static void main(String[] args) {
		binarystar app = new binarystar();
		app.start();
	}

}