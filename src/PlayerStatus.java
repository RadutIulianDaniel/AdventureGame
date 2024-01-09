
public class PlayerStatus {
	private String nikname;
	private String weaponInHand;
	private int score;
	private int lives;
	private int health;
	private double positionX;
	private double positionY;
	public static String gameName;
	
	public PlayerStatus(String nikname) {
		this.nikname = nikname;
		this.lives = 1;
		this.score = 20000;
		this.health = 100;
	}
	
	public PlayerStatus(String nikname, int lives) {
		this.nikname = nikname;
		this.lives = lives;
		this.score = 20000;
		this.health = 100;
	}
	
	public PlayerStatus(String nikname, int lives, int score) {
		this.nikname = nikname;
		this.lives = lives;
		this.score = score;
		this.health = 100;
	}

	public String getWeaponInHand() {
		if(weaponInHand == null) {
			return "Invalid weapon or not enough money!!";
		}
		return weaponInHand;
	}
	
	public boolean setWeaponInHand(String weaponInHand) {
		if(weaponInHand.equals("sniper") && this.score >= 10000) {
			this.weaponInHand = weaponInHand;
			this.score -= 10000;
			return true;
		}
		if (weaponInHand.equals("kalashnikov") && this.score >= 20000) {
			this.weaponInHand = weaponInHand;
			this.score -= 20000;
			return true;
		}
		if (weaponInHand.equals("knife") && this.score >= 1000) {
			this.weaponInHand = weaponInHand;
			this.score -= 1000;
			return true;
		}
		return false;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public String getGameName() {
		return gameName;
	}

	static void setGameName(String gameName) {
		PlayerStatus.gameName = gameName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getNikname() {
		return nikname;
	}
	
	public void findArtifact(int artifactCode) {
		if (isPerfectNumber(artifactCode) == true) {
			this.score += 5000;
			this.lives += 1;
			if(this.health > 100) {
				this.health = 100;
			}
		}
		if(isPrime(artifactCode)) {
			this.score += 1000;
			this.lives += 2;
			this.health += 25;
			if(this.health > 100) {
				this.health = 100;
			}
		}
	
		if (isATrap(artifactCode)) {
			this.score -= 3000;
			this.health -= 25;
				if(this.health <= 0) {
					this.lives -= 1;
					this.health = 100;
				}
				if(this.health <= 100 && this.lives <= 1) {
					System.out.println("GAME OVER!");
					System.exit(artifactCode);
				}
		}
	
		if (isOtherNumber(artifactCode)) {
			this.score += artifactCode;
		}
	}

	private boolean isPerfectNumber(int number) {
		int sumDiv = 1;
		if (number <= 1) {
			return false;
		}
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
			sumDiv += i;
			}
		}
		if (number == sumDiv) {
			return true;
		}
	return false;
	}
	
	private boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isATrap(int number) {
		int sum = 0, lastDigit, copyNumber = number;
		while (number > 0) {
			lastDigit = number % 10;
			sum += lastDigit;
			number = number / 10;
		}
		if (copyNumber != 0 && copyNumber % 2 == 0 && 
				sum % 3 == 0 && copyNumber != 6) {
			return true;
		}
		return false;
	}
	
	private boolean isOtherNumber(int number) {
		if (isPerfectNumber(number) == false && isPrime(number) == false && isATrap(number) == false){
			return true;
		}
		return false;
	}
	
	public double distanceBetweenPlayers(double positionXPlayer1, double positionYPlayer1 , double positionXPlayer2, double positionYPlayer2) {
		return Math.sqrt(((positionXPlayer1 - positionXPlayer2) * (positionXPlayer1 - positionXPlayer2)) + 
				((positionYPlayer1 - positionYPlayer2) * (positionYPlayer1 - positionYPlayer2)));
	}
	
	private int winProbability(int health, int score) {
		int result = (3 * health + score / 1000) / 4;
		return result;
	}
	
	public boolean shouldAttackOpponent(PlayerStatus Player2) {
		if(this.getWeaponInHand() == Player2.getWeaponInHand() && 
				(winProbability(this.health, this.score) >= winProbability(Player2.health, Player2.score))) {
			return true;
		}
		if(this.getWeaponInHand().equals("sniper") && Player2.getWeaponInHand() != "sniper" && 
				distanceBetweenPlayers(this.getPositionX(), this.getPositionY(), Player2.getPositionX(), Player2.getPositionY()) > 1000){
			return true;
		}
		if(this.getWeaponInHand().equals("kalashnikov") && Player2.getWeaponInHand().equals("knife") && 
				distanceBetweenPlayers(this.getPositionX(), this.getPositionY(), Player2.getPositionX(), Player2.getPositionY()) > 1000) {
			return true;
		}
		if(this.getWeaponInHand().equals("kalashnikov") && Player2.getWeaponInHand() != "kalasnikov" && 
				distanceBetweenPlayers(this.getPositionX(), this.getPositionY(), Player2.getPositionX(), Player2.getPositionY()) <= 1000) {
			return true;
		}
		if(this.getWeaponInHand().equals("sniper") && Player2.getWeaponInHand().equals("knife") && 
				distanceBetweenPlayers(this.getPositionX(), this.getPositionY(), Player2.getPositionX(), Player2.getPositionY()) <= 1000) {
			return true;
		}
		if((this.getWeaponInHand().equals("sniper") || this.getWeaponInHand().equals("kalashnikov") || this.getWeaponInHand().equals("knife")) && 
				(Player2.getWeaponInHand() != "kalasnikov" || Player2.getWeaponInHand() != "sniper" || Player2.getWeaponInHand() != "knife")){
			return true;
		}
		return false;
	}
}
