package org.example;

import java.util.List;
import java.util.Optional;

/*  This interface describes behaviour for objects
    which may implement CompositeBlock interface.
*/

public interface Structure {

    Optional<Block> findBlockByColor(String color);

    List<Block> findBlocksByMaterial(String material);

    int count();

}