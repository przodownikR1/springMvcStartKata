package pl.java.borowiec.dao;

import org.joda.time.DateTime;

import pl.java.borowiec.address.Address;
import pl.java.borowiec.blog.Blog;
import pl.java.borowiec.blog.BlogEntry;
import pl.java.borowiec.category.Category;
import pl.java.borowiec.comment.Comment;
import pl.java.borowiec.ranking.Ranking;
import pl.java.borowiec.ranking.RankingPK;
import pl.java.borowiec.tag.Tag;
import pl.java.borowiec.types.EntryState;
import pl.java.borowiec.types.Sex;
import pl.java.borowiec.user.User;
import pl.java.borowiec.user.UserRole;

public class InitExampleObject {
	protected UserRole userRoleAdmin, userRoleUser;
	protected User userSlawek, userTomek;
	protected Address addressSlawek, addressTomek;
	protected Tag tag1, tag2;
	protected Blog blogSlawek, blogTomek;
	protected BlogEntry blogSlawekEntry, blogTomekEntry;
	protected Ranking ranking1, ranking2;
	protected RankingPK rankPk1, rankPk2;
	protected Comment slawekComment, agnieszkaComment, tomekComment, zosiaComment;
	protected Category programming, java, python, spring, hibernate, car, sportCar;

	public InitExampleObject() {

		createUser();
		createTag();
		createBlog();
		createBlogEntry();
		createComment();
		createRanking();
		createCategory();
	}

	private void createCategory() {
		programming = new Category("programming");
		java = new Category("java");
		hibernate = new Category("hibernate");
		python = new Category("python");
		spring = new Category("spring");
		car = new Category("car");
		sportCar = new Category("sportCar");

		programming.addSubCategory(java);
		programming.addSubCategory(python);

		java.addSubCategory(spring);
		java.addSubCategory(hibernate);

		car.addSubCategory(sportCar);

	}

	private void createBlog() {
		blogSlawek = new Blog();
		blogTomek = new Blog();
		blogSlawek.setName("First Slawek Blog");
		blogSlawek.setOwner(userSlawek);
		blogTomek.setOwner(userTomek);
		blogTomek.setName("Tomek private experiences");
		blogSlawek.setCategory(programming);
		blogTomek.setCategory(car);
	}

	private void createBlogEntry() {
		blogSlawekEntry = new BlogEntry();
		blogTomekEntry = new BlogEntry();
		blogSlawekEntry.setAuthor("slawek borowiec");
		blogSlawekEntry.setBlog(blogSlawek);
		blogSlawekEntry.setContent("ABC ..... itd");
		blogSlawekEntry.setTitle("Something about spring programming");
		blogSlawekEntry.setEntryState(EntryState.DRAFT);
		blogSlawekEntry.setAllowComment(true);

		blogTomekEntry.setAuthor("Tomek Kowalski");
		blogTomekEntry.setBlog(blogTomek);
		blogTomekEntry.setContent("Personal life experiences");
		blogTomekEntry.setTitle("A couple words about me....");
		blogTomekEntry.setEntryState(EntryState.PUBLISHED);
		blogTomekEntry.setAllowComment(false);
		blogSlawekEntry.setComment(tomekComment);

	}

	private void createComment() {
		slawekComment = new Comment();
		agnieszkaComment = new Comment();
		zosiaComment = new Comment();
		tomekComment = new Comment();
		tomekComment.setTitle("Stek bzdur piszesz");
		tomekComment.setUserName("unknown tomek");
		tomekComment.setContent("Twój blog jest do niczego , patalachu");

		zosiaComment.setContent("Ala ma kota");
		zosiaComment.setUserName("zosia samosia");
		zosiaComment.setContent("Abecadło z pieca spadło");

		agnieszkaComment = new Comment();
		agnieszkaComment.setUserName("agnieszka z Warszawy");
		agnieszkaComment.setTitle("Cos ode mnie ..");
		agnieszkaComment.setContent("Dodam , że Twoje argumenty są do niczego");

		slawekComment.setOwner(userSlawek);
		slawekComment.setContent("Test personalBloga 1.2.3. start");
		slawekComment.setTitle("My first entry ...");

		slawekComment.getSubComments().add(tomekComment);

	}

	private void createRanking() {
		rankPk1 = new RankingPK("Blog", 1l);
		rankPk2 = new RankingPK("Entry", 1l);
		ranking1 = new Ranking(rankPk1);
		ranking2 = new Ranking(rankPk2);
	}

	private void createTag() {
		tag1 = new Tag();
		tag1.setName("spring");
		tag2 = new Tag();
		tag2.setName("hibernate");

	}

	private void createUser() {
		userRoleAdmin = new UserRole();
		userRoleAdmin.setRole("ROLE_ADMIN");
		userRoleUser = new UserRole();
		userRoleUser.setRole("ROLE_USER");
		userSlawek = new User();
		userTomek = new User();
		addressSlawek = new Address();
		addressTomek = new Address();
		addressSlawek.setCountry("Poland");
		addressSlawek.setStreetNumber("17");
		addressSlawek.setTown("Iłza");
		addressSlawek.setStreet("Blazińska");
		addressSlawek.setZipcode("27-100");

		addressTomek.setCountry("Poland");
		addressTomek.setTown("Warszawa");
		addressTomek.setZipcode("04-128");
		addressTomek.setStreet("Omulewska");
		addressTomek.setHomeNumber("9");
		addressTomek.setStreetNumber("7");

		userSlawek.setAddress(addressSlawek);
		userTomek.setAddress(addressTomek);

		userSlawek.setFirstName("Slawek");
		userSlawek.setLastName("Borowiec");
		userSlawek.setEmail("przodownik@tlen.pl");
		userSlawek.setLogin("przodownik");
		userSlawek.setPhoneNumber("516167490");
		userSlawek.setSex(Sex.FEMALE);
		userSlawek.getRoles().add(userRoleAdmin);
		userSlawek.getRoles().add(userRoleUser);
		userSlawek.setPassword("slawek1234");

		userSlawek.setActive(true);
		userSlawek.setBirthDate(new DateTime(1979, 5, 3, 0, 0).toDate());

		userTomek.setFirstName("Tomek");
		userTomek.setLastName("Kowalalski");
		userTomek.setEmail("przodownikR1@gmail.com");
		userTomek.setLogin("pospolity");
		userTomek.setPhoneNumber("516178234");
		userTomek.setSex(Sex.FEMALE);
		userTomek.getRoles().add(userRoleUser);
		userTomek.setPassword("tomek1234");
		userTomek.setActive(true);
		userTomek.setBirthDate(new DateTime(1980, 3, 3, 0, 0).toDate());
	}

}
