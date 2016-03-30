import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.sko01.helper.BenchmarkRunner;

import java.util.*;

public class BenchmarkApp {
    public static void printResults(Map<String , Map<String, Long>> results){
        for(Map.Entry entry : results.entrySet()){
            System.out.println(entry.getKey());
            Map<String, Long> testResults = (Map<String, Long>) entry.getValue();

            Set<String> keys = testResults.keySet();
            for(String key : keys){
                System.out.printf("%-18s", key);
            }
            System.out.printf("\n");
            Collection<Long> values = testResults.values();
            for(Long value : values){
                System.out.printf("%-18d", value);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args){
        int iterations = 100;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        BenchmarkRunner collectionBenchmarkRunner = (BenchmarkRunner)ctx.getBean("benchmarkRunner");
        collectionBenchmarkRunner.setIterations(iterations);
        Map<String, Map<String, Long>> results = collectionBenchmarkRunner.runTests();
        System.out.println("\nPrerequisites: Operations done with Collections of 1 000 000 elements and for " + iterations + " iterations");
        printResults(results);
    }
}
