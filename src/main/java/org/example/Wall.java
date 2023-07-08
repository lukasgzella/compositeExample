package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/*  I recognized this class as Composite in Composite Design Pattern.
    It stores child components and implements
    child related operations in the component interface.
*/

public class Wall implements Structure, CompositeBlock {

    private final List<Block> blocks = new ArrayList<>();
    private final List<CompositeBlock> compositeBlocks = new ArrayList<>();

    /*  Merges two lists (blocks and compositeBlocks) into one big list
        and flattens it to list of primitive blocks.
    */
    @Override
    public List<Block> getBlocks() {
        return Stream.concat(
                        compositeBlocks.stream().flatMap(compositeBlock -> compositeBlock.getBlocks().stream()),
                        blocks.stream())
                .toList();
    }

    /*  Returns all the colors that make up the wall.
     */
    @Override
    public String getColor() {
        return getBlocks().stream().map(Block::getColor).distinct().toList().toString();
    }

    /*  Returns all the materials that make up the wall.
     */
    @Override
    public String getMaterial() {
        return getBlocks().stream().map(Block::getMaterial).distinct().toList().toString();
    }

    /*  Returns single block made of requested color.
     */
    @Override
    public Optional<Block> findBlockByColor(String color) {
        return getBlocks().stream().filter(block -> block.getColor().equals(color)).findAny();
    }

    /*  Returns list of blocks made of requested material.
     */
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return getBlocks().stream().filter(block -> block.getMaterial().equals(material)).toList();
    }

    /*  Returns number of blocks the wall is made of.
     */
    @Override
    public int count() {
        return getBlocks().size();
    }

    // Builds wall of certain block. (I added this method for testing purpose).
    public void add(Block block) {
        if (block instanceof CompositeBlock) {
            compositeBlocks.add((CompositeBlock) block);
        } else
            blocks.add(block);
    }
}