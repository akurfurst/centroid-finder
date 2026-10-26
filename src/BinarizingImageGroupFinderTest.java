import org.junit.jupiter.api.Assertions.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

class BinarizingImageGroupFinderTest {
    // TODO: Replace w/ CSV formatted via ChatGPT
    private final List<Group> groupsList = List.of(
        new Group(6987, new Coordinate(533, 510)),
        new Group(5564, new Coordinate(185, 453)),
        new Group(5187, new Coordinate(586, 195)),
        new Group(5115, new Coordinate(371, 244)),
        new Group(7, new Coordinate(617, 229)),
        new Group(7, new Coordinate(377, 280)),
        new Group(6, new Coordinate(592, 233)),
        new Group(5, new Coordinate(611, 231)),
        new Group(5, new Coordinate(573, 235)),
        new Group(5, new Coordinate(373, 286)),
        new Group(4, new Coordinate(599, 232)),
        new Group(4, new Coordinate(582, 234)),
        new Group(2, new Coordinate(564, 236)),
        new Group(2, new Coordinate(507, 552)),
        new Group(2, new Coordinate(501, 556)),
        new Group(2, new Coordinate(497, 558)),
        new Group(2, new Coordinate(196, 487)),
        new Group(1, new Coordinate(551, 550)),
        new Group(1, new Coordinate(546, 551)),
        new Group(1, new Coordinate(371, 281)),
        new Group(1, new Coordinate(368, 282)),
        new Group(1, new Coordinate(228, 470)),
        new Group(1, new Coordinate(167, 494)),
        new Group(1, new Coordinate(152, 498))
    );
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