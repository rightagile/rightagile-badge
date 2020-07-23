package rightagile.badge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rightagile.badge.aggregate.category.logic.CategoryLogic;
import rightagile.badge.facade.aggregate.category.sdo.CategoryCdo;
import rightagile.badge.facade.aggregate.category.sdo.SubcategoryCdo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class BadgeBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BadgeBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CategoryLogic categoryLogic) {
        return (args) -> {
            categoryLogic.registerCategory(new CategoryCdo("", "AI", "1"));
            categoryLogic.registerCategory(new CategoryCdo("", "DT", "2"));
            categoryLogic.registerCategory(new CategoryCdo("", "행복", "3"));
            categoryLogic.registerCategory(new CategoryCdo("", "SV", "4"));
            categoryLogic.registerCategory(new CategoryCdo("", "혁신디자인", "5"));
            categoryLogic.registerCategory(new CategoryCdo("", "Global", "6"));

            categoryLogic.registerSubcategoryOfCategory(1L, new SubcategoryCdo("", "AI/DT Litercay", "1-1"));
            categoryLogic.registerSubcategoryOfCategory(1L, new SubcategoryCdo("", "AI Fundamentals", "1-2"));
            categoryLogic.registerSubcategoryOfCategory(1L, new SubcategoryCdo("", "AI Biz. Implementation", "1-3"));
            categoryLogic.registerSubcategoryOfCategory(1L, new SubcategoryCdo("", "AI Tech. Essential", "1-4"));
            categoryLogic.registerSubcategoryOfCategory(1L, new SubcategoryCdo("", "Computer Vision AI", "1-5"));
            categoryLogic.registerSubcategoryOfCategory(1L, new SubcategoryCdo("", "Language AI", "1-6"));
            categoryLogic.registerSubcategoryOfCategory(1L, new SubcategoryCdo("", "Speech AI", "1-7"));
            categoryLogic.registerSubcategoryOfCategory(1L, new SubcategoryCdo("", "AI Tech. Advanced", "1-8"));

            categoryLogic.registerSubcategoryOfCategory(2L, new SubcategoryCdo("", "Data Analytics", "2-1"));
            categoryLogic.registerSubcategoryOfCategory(2L, new SubcategoryCdo("", "Data Engineering", "2-2"));
            categoryLogic.registerSubcategoryOfCategory(2L, new SubcategoryCdo("", "Cloud  Engineering", "2-3"));

            categoryLogic.registerSubcategoryOfCategory(3L, new SubcategoryCdo("", "행복의 이해", "3-1"));
            categoryLogic.registerSubcategoryOfCategory(3L, new SubcategoryCdo("", "행복 추구 실천", "3-2"));

            categoryLogic.registerSubcategoryOfCategory(4L, new SubcategoryCdo("", "SV 이해", "4-1"));
            categoryLogic.registerSubcategoryOfCategory(4L, new SubcategoryCdo("", "SV 심화", "4-2"));
            categoryLogic.registerSubcategoryOfCategory(4L, new SubcategoryCdo("", "SV 체험", "4-3"));

            categoryLogic.registerSubcategoryOfCategory(5L, new SubcategoryCdo("", "Deep Change와 Design", "5-1"));

            categoryLogic.registerSubcategoryOfCategory(6L, new SubcategoryCdo("", "Managing Global Biz", "6-1"));
        };
    }
}
