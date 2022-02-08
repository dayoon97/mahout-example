package com.example.mahoutexample.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.List;

/**
 * TestApp
 *
 * @author dySim
 * @since 2022-02-08
 */
@Slf4j
public class TestApp {

    public void readRecommend() {

        //파일 읽기
        DataModel model = new FileDataModel(new File());

        //유저 기준 유사성
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

        //0.1보다 큰 유사성을 가진 모든 것을 사용, thresSholdUserNeighborhodd를 통해 구현
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);

        //유저 기준 추천 모델
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

        //2번 유저에게 1개 아이템 추천 => (2, 1)
        List<RecommendedItem> recommendations = recommender.recommend(2, 1);
        for(RecommendedItem recommendedItem : recommendations) {
            log.info("recommendation={}", recommendations);
        }


    }
}
