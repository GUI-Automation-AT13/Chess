/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package src.piecesMoves;

import org.junit.Assert;
import org.junit.Test;
import src.PiecesMoves.LinedMove;

public class LinedMoveTest {

    @Test
    public void isInLimits1ShouldReturnTrue() {
        LinedMove linedMove = new LinedMove();
        Assert.assertTrue(linedMove.isInLimits(0));
    }

    @Test
    public void isInLimits7ShouldReturnTrue() {
        LinedMove linedMove = new LinedMove();
        Assert.assertTrue(linedMove.isInLimits(7));
    }

    @Test
    public void isInLimits8ShouldReturnFalse() {
        LinedMove linedMove = new LinedMove();
        Assert.assertFalse(linedMove.isInLimits(8));
    }

    @Test
    public void isInLimitsNegative1ShouldReturnFalse() {
        LinedMove linedMove = new LinedMove();
        Assert.assertFalse(linedMove.isInLimits(-1));
    }
}
