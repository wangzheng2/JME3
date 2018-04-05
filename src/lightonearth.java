import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;

public class lightonearth extends SimpleApplication {

	private Geometry geom;


	@Override
	public void simpleInitApp() {
		
		// #1 ����һ��Բ�ε�����
		Mesh mesh = new Sphere(16, 24, 1);

        // #2 ����һ���й����
        Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");

        // #3 ����һ�������壬Ӧ�øղź�����Ͳ��ʡ�
        geom = new Geometry("Box");
        geom.setMesh(mesh);
        geom.setMaterial(mat);

        // #4 ����һ�����⣬������б�������䣬��ʹ�����ܹ������Ǹ����顣
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-1, -2, -3));
        
        // #5 ������Ͷ���ӵ�����ͼ��
        rootNode.attachChild(geom);
        rootNode.addLight(sun);       
	}
	
	/**
	 * ��ѭ��
	 */
	@Override
	public void simpleUpdate(float deltaTime) {
		// ��ת�ٶȣ�ÿ��360��
		float speed = FastMath.TWO_PI;
		// �÷���������ת
		geom.rotate(0, deltaTime * speed, 0);
	}

	public static void main(String[] args) {
		// ���ò���
		AppSettings settings = new AppSettings(true);
		settings.setTitle("һ������");
		settings.setResolution(480, 720);
		
		// ����jME3����
		lightonearth app = new lightonearth();
		app.setSettings(settings);// Ӧ�ò���
		app.setShowSettings(false);
		app.start();
	}
}
