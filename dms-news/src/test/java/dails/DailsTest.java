package dails;

import com.dms.Branch1;
import com.dms.FactoryBranch1;
import com.dms.domain.News;
import com.dms.domain.NewsLog;
import com.dms.domain.Notice;
import com.dms.domain.SUser;

public class DailsTest {

	public static void main(String[] args) {
		FactoryBranch1 fbranch1 = new FactoryBranch1();
		Branch1 branch1 = fbranch1.createExample();
		branch1.setRooturl("E:/work/dms/dms/dails-project/dms-news");
		branch1.setUrl("com/dms");
//		 branch1.initFiles();

		branch1.setEntityClass(SUser.class);
//		 branch1.initJava();
		branch1.initJsp();

	}

}
