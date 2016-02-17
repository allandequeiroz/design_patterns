//package java4.fun;
//
//public class InsereDados {
//
//	public static void main(String[] args) {
//		DaoFactory factory = new DaoFactory();
//		UsuarioDao udao = factory.getUsuarioDao();
//		Dao<Cd> cdao = factory.getCdDao();
//		Dao<Musica> mdao = factory.getMusicaDao();
//		
//		factory.beginTransaction();
//		
//		{
//			Usuario u = new Usuario();
//			u.setLogin("admin");
//			u.setSenha("admin");
//			udao.adiciona(u);
//		}
//		
//		{
//			Cd cd = new Cd();
//			cd.setTitulo("Clássicos de Bryn Badel");
//			cd.setArtista("Bryn Badel");
//			cd.setGenero("Clássico");
//			cd.setImagemCapa("1.jpeg");
//			
//			Musica m1 = new Musica();
//			m1.setTitulo("Bernies Tune");
//			m1.setPreco(0.99);
//			m1.setMp3("cd1/faixa1.mp3");
//			m1.setCd(cd);
//			
//			Musica m2 = new Musica();
//			m2.setTitulo("Guiseppe Torelli - Concerto in D");
//			m2.setPreco(0.99);
//			m2.setMp3("cd1/faixa2.mp3");
//			m2.setCd(cd);
//			
//			cdao.adiciona(cd);
//			mdao.adiciona(m1);
//			mdao.adiciona(m2);
//		}
//		
//		{
//			Cd cd = new Cd();
//			cd.setTitulo("Copperopolis");
//			cd.setArtista("Charlie Hunter");
//			cd.setGenero("Jazz");
//			cd.setImagemCapa("2.jpeg");
//			
//			Musica m1 = new Musica();
//			m1.setTitulo("A Street Fight Could Break Out");
//			m1.setPreco(0.99);
//			m1.setMp3("cd2/faixa1.mp3");
//			m1.setCd(cd);
//			
//			Musica m2 = new Musica();
//			m2.setTitulo("Copperopolis");
//			m2.setPreco(0.99);
//			m2.setMp3("cd2/faixa2.mp3");
//			m2.setCd(cd);
//
//			Musica m3 = new Musica();
//			m3.setTitulo("Cueball Bobbin");
//			m3.setPreco(0.99);
//			m3.setMp3("cd2/faixa3.mp3");
//			m3.setCd(cd);
//			
//			cdao.adiciona(cd);
//			mdao.adiciona(m1);
//			mdao.adiciona(m2);
//			mdao.adiciona(m3);
//		}	
//
//		{
//			Cd cd = new Cd();
//			cd.setTitulo("Experiences");
//			cd.setArtista("D.J. Beacon");
//			cd.setGenero("Electronic dance");
//			cd.setImagemCapa("3.jpeg");
//			
//			Musica m1 = new Musica();
//			m1.setTitulo("Experiences");
//			m1.setPreco(0.99);
//			m1.setMp3("cd3/faixa1.mp3");
//			m1.setCd(cd);
//			
//			Musica m2 = new Musica();
//			m2.setTitulo("Fool Love");
//			m2.setPreco(1.49);
//			m2.setMp3("cd3/faixa2.mp3");
//			m2.setCd(cd);
//
//			Musica m3 = new Musica();
//			m3.setTitulo("Outsider");
//			m3.setPreco(1.39);
//			m3.setMp3("cd3/faixa3.mp3");
//			m3.setCd(cd);
//
//			Musica m4 = new Musica();
//			m4.setTitulo("Pray For You");
//			m4.setPreco(1.39);
//			m4.setMp3("cd3/faixa4.mp3");
//			m4.setCd(cd);
//			
//			cdao.adiciona(cd);
//			mdao.adiciona(m1);
//			mdao.adiciona(m2);
//			mdao.adiciona(m3);
//			mdao.adiciona(m4);
//		}
//
//		{
//			Cd cd = new Cd();
//			cd.setTitulo("Goo Goo Cluster");
//			cd.setArtista("Goo Goo Cluster");
//			cd.setGenero("Reggae");
//			cd.setImagemCapa("4.jpeg");
//			
//			Musica m1 = new Musica();
//			m1.setTitulo("Dur-dur decirctre lui");
//			m1.setPreco(0.99);
//			m1.setMp3("cd4/faixa1.mp3");
//			m1.setCd(cd);
//			
//			Musica m2 = new Musica();
//			m2.setTitulo("You Can't Make No Noise In Paris, France");
//			m2.setPreco(0.89);
//			m2.setMp3("cd4/faixa2.mp3");
//			m2.setCd(cd);
//			
//			cdao.adiciona(cd);
//			mdao.adiciona(m1);
//			mdao.adiciona(m2);
//		}
//
//		{
//			Cd cd = new Cd();
//			cd.setTitulo("Operation Rock");
//			cd.setArtista("Operation Rock");
//			cd.setGenero("Rock");
//			cd.setImagemCapa("5.jpeg");
//			
//			Musica m1 = new Musica();
//			m1.setTitulo("Hell or High Water");
//			m1.setPreco(0.99);
//			m1.setMp3("cd5/faixa1.mp3");
//			m1.setCd(cd);
//			
//			Musica m2 = new Musica();
//			m2.setTitulo("Hide Your Love");
//			m2.setPreco(0.99);
//			m2.setMp3("cd5/faixa2.mp3");
//			m2.setCd(cd);
//
//			Musica m3 = new Musica();
//			m3.setTitulo("Mind Eraser");
//			m3.setPreco(0.99);
//			m3.setMp3("cd5/faixa3.mp3");
//			m3.setCd(cd);
//			
//			cdao.adiciona(cd);
//			mdao.adiciona(m1);
//			mdao.adiciona(m2);
//			mdao.adiciona(m3);
//		}
//
//		{
//			Cd cd = new Cd();
//			cd.setTitulo("Mozart - Symphonies nr 40&41");
//			cd.setArtista("The English Concert");
//			cd.setGenero("Clássico");
//			cd.setImagemCapa("6.jpeg");
//			
//			Musica m1 = new Musica();
//			m1.setTitulo("I: Molto allegro");
//			m1.setPreco(0.59);
//			m1.setMp3("cd6/faixa1.mp3");
//			m1.setCd(cd);
//			
//			Musica m2 = new Musica();
//			m2.setTitulo("II: Andante");
//			m2.setPreco(0.59);
//			m2.setMp3("cd6/faixa2.mp3");
//			m2.setCd(cd);
//
//			Musica m3 = new Musica();
//			m3.setTitulo("III: Menuetto: Allegretto- trio");
//			m3.setPreco(0.59);
//			m3.setMp3("cd6/faixa3.mp3");
//			m3.setCd(cd);
//
//			Musica m4 = new Musica();
//			m4.setTitulo("Allegro assai");
//			m4.setPreco(0.59);
//			m4.setMp3("cd6/faixa4.mp3");
//			m4.setCd(cd);
//			
//			cdao.adiciona(cd);
//			mdao.adiciona(m1);
//			mdao.adiciona(m2);
//			mdao.adiciona(m3);
//			mdao.adiciona(m4);
//		}
//		
//		factory.commit();
//	}
//}
// 
