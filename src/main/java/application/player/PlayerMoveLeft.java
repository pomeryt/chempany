package application.player;

import javafx.scene.Camera;
import javafx.scene.Node;
import plain.contract.entity.VoidTaskOfEntity;

public final class PlayerMoveLeft implements VoidTaskOfEntity<Player> {

	public PlayerMoveLeft(final Camera camera, final double speed) {
		this.camera = camera;
		this.speed = speed;
	}
	
	@Override
	public void handle(final Player player) {
		final Node playerBody = player.body.value();
		
		player.actionMap.update("left", () -> {
			playerBody.setTranslateX(playerBody.getTranslateX() - this.speed);
			this.camera.setTranslateX(this.camera.getTranslateX() - this.speed);
			
			if (this.speed != 0) {
				player.moveEvents.forEach(event -> event.handle(player));
			}
		});
	}
	
	private final Camera camera;
	private final double speed;
}