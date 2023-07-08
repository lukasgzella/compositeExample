package org.example;

import java.util.List;

/*  I recognized this interface as a Component in Composite Design Pattern
    which declares the interface for objects in the composition.
*/

public interface CompositeBlock extends Block {

    List<Block> getBlocks();

}
