package metier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class UserMetier {

	public void copyImageByFile(File sourceFile, String destinationPath) {

		if (!sourceFile.exists()) {
			System.out.println("Le fichier source n'existe pas.");
			return;
		}
		Path destination = Path.of(destinationPath);

		try {
			Files.copy(sourceFile.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("L'image a été copiée avec succès !");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyImageByPath(String sourcePath, String destinationPath) {
		Path source = Path.of(sourcePath);
		Path destination = Path.of(destinationPath);

		try {
			Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("L'image a été copiée avec succès !");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
