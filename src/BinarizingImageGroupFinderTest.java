import org.junit.jupiter.api.Assertions.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

class BinarizingImageGroupFinderTest {
    // TODO: Replace w/ CSV formatted via ChatGPT
    private final List<Group> groupsList = null;
    @Test
    void Test() {
        ColorDistanceFinder distanceFinder = new EuclideanColorDistance();
        ImageBinarizer binarizer = new DistanceImageBinarizer(distanceFinder, 0xFFFFFF, 50);
        BinaryGroupFinder groupFinder = new DfsBinaryGroupFinder();
        ImageGroupFinder finder = new BinarizingImageGroupFinder(binarizer, groupFinder);

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("sampleInput/squares.jpg"));
        } catch (Exception error) {
            System.out.println(error);
            System.exit(-1);
        }

        List<Group> actual = finder.findConnectedGroups(image);

        List<Group> expected = groupsList;
    }
}