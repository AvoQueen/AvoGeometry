package debug_scene;

import avogeom.Line;
import avogeom.Segment;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DebugScene extends Application {

	public static final String TITLE = "AvoGeometry Debug Scene";
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public static Canvas c;
	public static GraphicsContext ctx;
	
	private static double mouseX = WIDTH / 2, mouseY = HEIGHT / 2;

	@Override
	public void start(Stage stage) {
		
		stage.setTitle(TITLE);
		stage.setResizable(false);
		
		Line l1 = new Line(100, 100, 200, 100);
		Line l2 = new Line(300, 100, 320, 320);
	
		Group root = new Group(c);
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		
		root.setOnMouseMoved(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent event) {
		        mouseX = event.getSceneX();
		        mouseY = event.getSceneY();
		    }
		});
		
		new AnimationTimer() {
            @Override
            public void handle(long now) {
            	ctx.clearRect(0, 0, WIDTH, HEIGHT);
            	l1.show();
            	l2.show();
            	Segment s1 = l1.getSegment();
        		Segment s2 = l2.getSegment();
            	
            	ctx.fillText("Intersection: "+l1.intersects(l2), 20, 20);
            	ctx.fillText("Intersection: "+s1.intersects(s2), 20, 40);
            	ctx.fillText("Intersection: "+s1._intersects(s2), 20, 60);
            	
            	ctx.fillText("l1 heading: "+l1.heading().toString(), 20, 100);
            	ctx.fillText("l2 heading: "+l2.heading().toString(), 20, 120);
            	
            	l1.setCenter(mouseX, mouseY);
            }
        }.start();
		
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		DebugScene.c = new Canvas(WIDTH, HEIGHT);
		DebugScene.ctx = DebugScene.c.getGraphicsContext2D();
		
		launch(args);
	}
}
