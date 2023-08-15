package main;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class Sound {
    Clip clip;

    public static void loadSounds(List<String> soundFilesIdentifiers) {
        soundFilesIdentifiers.forEach(Sound::loadSound);
    }

    private static void loadSound(String path) {
        try {
            URL url = Objects.requireNonNull(Sound.class.getResource(path));
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void setSoundFile(String soundFile) {
        try {
            URL url = Objects.requireNonNull(getClass().getResource(soundFile));
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
