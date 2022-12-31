package program;

public class Ball {
	
	public double ballX;
	public double ballY;
	public double velocityY = 0;
	public double velocityX = 0;
	
	
	public boolean collision = false;
	
	public Ball(double bx, double by) {
		ballX = bx;
		ballY = by;
	}
	
	public void ballGravity() {
		if (ballY + 50 < Panel.WINDOW_HEIGHT) {
			velocityY += 0.00000000005;
			collision = false;
			
		} else if (ballY + 50 > Panel.WINDOW_HEIGHT) {
			velocityY = (velocityY * -1) / 2;
			ballY = Panel.WINDOW_HEIGHT - 50;
			collision = true;
		}
		
		if (ballX + 50 < Panel.WINDOW_WIDTH && ballX > 0) {
			velocityY += 0.00000000005;
			
		} else if (ballX + 50 > Panel.WINDOW_WIDTH) {
			velocityX = (velocityX * -1) / 2;
			ballX = Panel.WINDOW_WIDTH - 50;
		} else if ( ballX < 0) {
			velocityX = (velocityX * -1) / 2;
			ballX = 0;
		}
		
		if (collision == true) {
			if (velocityX > 0) {
				velocityX -= 0.00000000005;
			} else if (velocityX < 0) {
				velocityX += 0.00000000005;
			}
		}
		
		
		//System.out.println(ballX);
		ballX += velocityX;
		ballY += velocityY;
	}
	
	public void checkBallCollision(Ball b) {
		
		double ballDifferenceX = (ballX + 25) - (b.getX() + 25);
		double ballDifferenceY = (ballY + 25) - (b.getY() + 25);
		
		double totalVelocity = java.lang.Math.abs(velocityX + velocityY + b.velocityX + b.velocityY);
		
		//System.out.println(totalVelocity);

		if (java.lang.Math.sqrt(java.lang.Math.pow(ballDifferenceX, 2) + java.lang.Math.pow(ballDifferenceY, 2)) < 50) { 
			
			if (totalVelocity < 0.000005) {
				totalVelocity = 0.00005;
			}
			
			velocityX = (ballDifferenceX * totalVelocity) / 130;
			velocityY = (ballDifferenceY * totalVelocity) / 130;
			
			
		}
	}
	
	public double getVelocityX() {
		return velocityX;
	}
	
	public double getVelocityY() {
		return velocityY;
	}
	
	public double getX() {
		return ballX;
	}
	
	public double getY() {
		return ballY;
	}
}
