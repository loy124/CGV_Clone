package bit.com.a.model;

public class CGVInfoDto {

	String rank;
	String img;
	String movieAge;
	String movieTitle;
	String movieRate; //예매율
	String movieOpenDate; //개봉일
	String like;
	int seq;
	
	public CGVInfoDto() {
		// TODO Auto-generated constructor stub
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMovieAge() {
		return movieAge;
	}

	public void setMovieAge(String movieAge) {
		this.movieAge = movieAge;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieRate() {
		return movieRate;
	}

	public void setMovieRate(String movieRate) {
		this.movieRate = movieRate;
	}

	public String getMovieOpenDate() {
		return movieOpenDate;
	}

	public void setMovieOpenDate(String movieOpenDate) {
		this.movieOpenDate = movieOpenDate;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public CGVInfoDto(String rank, String img, String movieAge, String movieTitle, String movieRate,
			String movieOpenDate, String like, int seq) {
		super();
		this.rank = rank;
		this.img = img;
		this.movieAge = movieAge;
		this.movieTitle = movieTitle;
		this.movieRate = movieRate;
		this.movieOpenDate = movieOpenDate;
		this.like = like;
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "CGVInfoDto [rank=" + rank + ", img=" + img + ", movieAge=" + movieAge + ", movieTitle=" + movieTitle
				+ ", movieRate=" + movieRate + ", movieOpenDate=" + movieOpenDate + ", like=" + like + ", seq=" + seq
				+ "]";
	}

	
	
	
	
	
}
	