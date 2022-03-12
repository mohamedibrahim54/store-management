package com.techmaker.storemanagement.lucene;

import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;

public class MyLuceneAnalysisConfigurer implements LuceneAnalysisConfigurer {

	@Override
	public void configure(LuceneAnalysisConfigurationContext context) {
		context.similarity(new ClassicSimilarity());
		context.analyzer("item-name").custom().tokenizer("standard").tokenFilter("lowercase")
				.tokenFilter("asciiFolding");

	}

}
