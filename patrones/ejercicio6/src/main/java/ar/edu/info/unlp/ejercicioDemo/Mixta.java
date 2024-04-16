package ar.edu.info.unlp.ejercicioDemo;

public class Mixta implements Topografia{
	Agua agua1;
	Agua agua2;
	Tierra tierra1;
	Tierra tierra2;
	Mixta mx;
	
	public Mixta(Agua a1, Agua a2, Tierra t1, Tierra t2) {
		this.agua1=a1;
		this.agua2=a2;
		this.tierra1=t1;
		this.tierra2=t2;
	}
	
	public void setMixta(Mixta mx) {
		this.mx = new Mixta(this.agua1,this.agua2,this.tierra1,this.tierra2);
	}
	
	@Override
	public double porcentaje() {
		// TODO Auto-generated method stub
		return (
				this.agua1.porcentaje() +
				this.tierra1.porcentaje()+
				this.tierra2.porcentaje()+
				this.agua2.porcentaje() 
				)/4;
	}
}
