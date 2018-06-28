package application.map;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import application.turtle.base.BtrCoordinate;

class TornadoPatternTest {

	@Test
	void testFromOrigin() {
		final List<Point> points = new LinkedList<>();
		
		new TornadoPattern(
			3, new Point(0, 0), 
			turtle -> {
				points.add(
					new Point(
						turtle.valueOf(new BtrCoordinate()).x,
						turtle.valueOf(new BtrCoordinate()).y
					)
				);
			}
		).makePattern();
		
		final List<Point> expectedPoints = new LinkedList<>();
		expectedPoints.add(new Point(0, 0));
		expectedPoints.add(new Point(1, 0));
		expectedPoints.add(new Point(1, 1));
		expectedPoints.add(new Point(0, 1));
		expectedPoints.add(new Point(-1, 1));
		expectedPoints.add(new Point(-1, 0));
		expectedPoints.add(new Point(-1, -1));
		expectedPoints.add(new Point(0, -1));
		expectedPoints.add(new Point(1, -1));
		
		assertThat(points, new IsEqual<>(expectedPoints));
	}

}
