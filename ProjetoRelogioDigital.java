import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjetoRelogioDigital extends Application {
	final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Override
	public void start(Stage palco) {
		Label rotuloTempo = new Label();
		rotuloTempo.setStyle("-fx-font-size: 32px; -fx-text-fill: yellow;");

		// Criacao de um KeyFrame
		KeyFrame keyFrameAtualizar = new KeyFrame(Duration.ZERO, e -> {
			rotuloTempo.setText(LocalDateTime.now().format(FORMATADOR));
		});

		// Criacao de outro KeyFrame que define o intervalo de atualização
		KeyFrame keyFrameIntervalo = new KeyFrame(Duration.seconds(1));

		// Criacao de Timeline e adicao dos KeyFrames
		Timeline relogio = new Timeline();
		relogio.getKeyFrames().addAll(keyFrameAtualizar, keyFrameIntervalo);

		// Definimos a acao de atualizar o rotulo com a hora atual
		// vai acontecer a cada segundo, para sempre
		relogio.setCycleCount(Animation.INDEFINITE);
		relogio.play(); // Inicia a Timeline

		VBox vboxLayout = new VBox(rotuloTempo);
		vboxLayout.setAlignment(Pos.CENTER);
		vboxLayout.setStyle("-fx-background-color: black;");

		Scene cena = new Scene(vboxLayout, 250, 100);

		palco.setTitle("Relógio Digital");
		palco.setScene(cena);
		palco.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}