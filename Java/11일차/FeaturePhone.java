package day6;

/*FeaturePhone class*/
public class FeaturePhone extends Phone{
	

	 private int pixel;
	//getter,setter 생성

	public int getPixel() {
		return pixel;
	}

	public void setPixel(int pixel) {
		this.pixel = pixel;
	}
	
	//takePicture메소드 생성([+pixel+]화소의 화질로 사진을 찍습니다.)
	public void takePicture() {
		System.out.println("["+pixel+"]화소의 화질로 사진을 찍습니다.");
	}

}
