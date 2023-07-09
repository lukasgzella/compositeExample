import org.example.Block;
import org.example.Wall;
import org.example.testObjects.SingleBlock;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {

    private Wall initCeramicConcreteWall() {
        Block redCeramicBlock = new SingleBlock("red", "ceramic");
        Block greyConcreteBlock = new SingleBlock("grey", "concrete");
        Block orangeCeramicBlock = new SingleBlock("orange", "ceramic");
        Block sandyConcreteBlock = new SingleBlock("sandy", "concrete");
        Wall wall = new Wall();
        wall.add(redCeramicBlock);
        wall.add(greyConcreteBlock);
        wall.add(orangeCeramicBlock);
        wall.add(sandyConcreteBlock);
        return wall;
    }

    private Wall initPlasticGlassWall() {
        Block yellowPlasticBlock = new SingleBlock("yellow", "plastic");
        Block bluePlasticBlock = new SingleBlock("blue", "plastic");
        Block transparentGlassBlock = new SingleBlock("transparent", "glass");
        Block greenGlassBlock = new SingleBlock("green", "glass");
        Wall wall = new Wall();
        wall.add(yellowPlasticBlock);
        wall.add(bluePlasticBlock);
        wall.add(transparentGlassBlock);
        wall.add(greenGlassBlock);
        return wall;
    }

    private Wall initComplexWall() {
        Wall ceramicConcreteWall = initCeramicConcreteWall();
        Wall plasticGlassWall = initPlasticGlassWall();
        Wall complexWall = new Wall();
        complexWall.add(ceramicConcreteWall);
        complexWall.add(plasticGlassWall);
        return complexWall;
    }

    private Wall initComplexNestedWall() {
        Wall complexWall_1 = initComplexWall();
        Wall complexWall_2 = initComplexWall();
        Wall complexNestedWall = new Wall();
        complexNestedWall.add(complexWall_1);
        complexNestedWall.add(complexWall_2);
        return complexNestedWall;
    }

    @Test
    public void getBlocks_ceramicConcreteWall_returnListOfBlocks() {
        //given
        Wall wall = initCeramicConcreteWall();
        List<Block> expected = List.of(
                new SingleBlock("red", "ceramic"),
                new SingleBlock("grey", "concrete"),
                new SingleBlock("orange", "ceramic"),
                new SingleBlock("sandy", "concrete")
        );
        //when
        List<Block> actual = wall.getBlocks();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getBlocks_plasticGlassWall_returnListOfBlocks() {
        //given
        Wall wall = initPlasticGlassWall();
        List<Block> expected = List.of(
                new SingleBlock("yellow", "plastic"),
                new SingleBlock("blue", "plastic"),
                new SingleBlock("transparent", "glass"),
                new SingleBlock("green", "glass")
        );
        //when
        List<Block> actual = wall.getBlocks();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getBlocks_complexWall_returnListOfBlocks() {
        //given
        Wall complexWall = initComplexWall();
        List<Block> expected = List.of(
                new SingleBlock("red", "ceramic"),
                new SingleBlock("grey", "concrete"),
                new SingleBlock("orange", "ceramic"),
                new SingleBlock("sandy", "concrete"),
                new SingleBlock("yellow", "plastic"),
                new SingleBlock("blue", "plastic"),
                new SingleBlock("transparent", "glass"),
                new SingleBlock("green", "glass")
        );
        List<Block> actual = complexWall.getBlocks();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getBlocks_complexNestedWall_returnListOfBlocks() {
        //given
        Wall complexNestedWall = initComplexNestedWall();
        List<Block> expected = List.of(
                new SingleBlock("red", "ceramic"),
                new SingleBlock("grey", "concrete"),
                new SingleBlock("orange", "ceramic"),
                new SingleBlock("sandy", "concrete"),
                new SingleBlock("yellow", "plastic"),
                new SingleBlock("blue", "plastic"),
                new SingleBlock("transparent", "glass"),
                new SingleBlock("green", "glass"),
                new SingleBlock("red", "ceramic"),
                new SingleBlock("grey", "concrete"),
                new SingleBlock("orange", "ceramic"),
                new SingleBlock("sandy", "concrete"),
                new SingleBlock("yellow", "plastic"),
                new SingleBlock("blue", "plastic"),
                new SingleBlock("transparent", "glass"),
                new SingleBlock("green", "glass")
        );
        List<Block> actual = complexNestedWall.getBlocks();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getColor_singleBlock_returnColor() {
        //given
        Block block = new SingleBlock("red", "ceramic");
        String expected = "red";
        //when
        String actual = block.getColor();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getColor_ceramicConcreteWall_returnColors() {
        //given
        Wall wall = initCeramicConcreteWall();
        String expected = List.of("red", "grey", "orange", "sandy").toString();
        //when
        String actual = wall.getColor();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getColor_complexWall_returnColors() {
        //given
        Wall wall = initComplexWall();
        String expected = List.of("red", "grey", "orange", "sandy", "yellow", "blue", "transparent", "green").toString();
        //when
        String actual = wall.getColor();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getColor_complexNestedWall_returnColors() {
        //given
        Wall wall = initComplexNestedWall();
        String expected = List.of(
                        "red", "grey", "orange", "sandy", "yellow", "blue", "transparent", "green"
                )
                .toString();
        //when
        String actual = wall.getColor();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getMaterial_singleBlock_returnMaterial() {
        //given
        Block block = new SingleBlock("red", "ceramic");
        String expected = "ceramic";
        //when
        String actual = block.getMaterial();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getMaterial_ceramicConcreteWall_returnMaterials() {
        //given
        Wall wall = initCeramicConcreteWall();
        String expected = List.of("ceramic", "concrete").toString();
        //when
        String actual = wall.getMaterial();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getMaterial_complexWall_returnMaterials() {
        //given
        Wall wall = initComplexWall();
        String expected = List.of("ceramic", "concrete", "plastic", "glass").toString();
        //when
        String actual = wall.getMaterial();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getMaterial_complexNestedWall_returnMaterials() {
        //given
        Wall wall = initComplexNestedWall();
        String expected = List.of("ceramic", "concrete", "plastic", "glass").toString();
        //when
        String actual = wall.getMaterial();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findBlockByColor_ceramicConcreteWall_returnOptionalWithBlock() {
        //given
        Wall wall = initCeramicConcreteWall();
        Optional<Block> expected = Optional.of(new SingleBlock("red", "ceramic"));
        //when
        Optional<Block> actual = wall.findBlockByColor("red");
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findBlockByColor_complexWall_returnOptionalWithBlock() {
        //given
        Wall wall = initComplexWall();
        Optional<Block> expected = Optional.of(new SingleBlock("red", "ceramic"));
        //when
        Optional<Block> actual = wall.findBlockByColor("red");
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findBlockByColor_complexNestedWall_returnOptionalWithBlock() {
        //given
        Wall wall = initComplexNestedWall();
        Optional<Block> expected = Optional.of(new SingleBlock("red", "ceramic"));
        //when
        Optional<Block> actual = wall.findBlockByColor("red");
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findBlockByColor_nonExistingColor_returnEmptyOptional() {
        //given
        Wall wall = initComplexNestedWall();
        Optional<Block> expected = Optional.empty();
        //when
        Optional<Block> actual = wall.findBlockByColor("black");
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findBlocksByMaterial_ceramicConcreteWall_returnListOfBlocks() {
        //given
        Wall wall = initCeramicConcreteWall();
        List<Block> expected = List.of(
                new SingleBlock("red", "ceramic"),
                new SingleBlock("orange", "ceramic")
        );
        //when
        List<Block> actual = wall.findBlocksByMaterial("ceramic");
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findBlocksByMaterial_complexWall_returnListOfBlocks() {
        //given
        Wall wall = initComplexWall();
        List<Block> expected = List.of(
                new SingleBlock("red", "ceramic"),
                new SingleBlock("orange", "ceramic")
        );
        //when
        List<Block> actual = wall.findBlocksByMaterial("ceramic");
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findBlocksByMaterial_complexNestedWall_returnListOfBlocks() {
        //given
        Wall wall = initComplexNestedWall();
        List<Block> expected = List.of(
                new SingleBlock("red", "ceramic"),
                new SingleBlock("orange", "ceramic"),
                new SingleBlock("red", "ceramic"),
                new SingleBlock("orange", "ceramic")
        );
        //when
        List<Block> actual = wall.findBlocksByMaterial("ceramic");
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void findBlocksByMaterial_nonExistingMaterial_returnEmptyList() {
        //given
        Wall wall = initComplexNestedWall();
        List<Block> expected = List.of();
        //when
        List<Block> actual = wall.findBlocksByMaterial("paper");
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void count_ceramicConcreteWall_returnInt() {
        //given
        Wall wall = initCeramicConcreteWall();
        int expected = 4;
        //when
        int actual = wall.count();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void count_complexWall_returnInt() {
        //given
        Wall wall = initComplexWall();
        int expected = 8;
        //when
        int actual = wall.count();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void count_complexNestedWall_returnInt() {
        //given
        Wall wall = initComplexNestedWall();
        int expected = 16;
        //when
        int actual = wall.count();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void count_emptyWall_returnZero() {
        //given
        Wall wall = new Wall();
        int expected = 0;
        //when
        int actual = wall.count();
        //then
        assertEquals(expected, actual);
    }
}