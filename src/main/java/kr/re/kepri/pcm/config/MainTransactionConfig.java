package kr.re.kepri.pcm.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Collections;
import java.util.List;

@Configuration
public class MainTransactionConfig {

    private final TransactionManager mainTransactionManager;

    private static final String EXPRESSION = "execution(public * kr.re.kepri.pcm.*.service.impl.*Impl.*(..))";

    public MainTransactionConfig(TransactionManager mainTransactionManager) {
        this.mainTransactionManager = mainTransactionManager;
    }

    @Bean
    public TransactionInterceptor mainTransactionAdvice() {
        List<RollbackRuleAttribute> rollbackRules = Collections.singletonList(new RollbackRuleAttribute(Exception.class));

        RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
        transactionAttribute.setRollbackRules(rollbackRules);
        transactionAttribute.setName("*");

        MatchAlwaysTransactionAttributeSource attributeSource = new MatchAlwaysTransactionAttributeSource();
        attributeSource.setTransactionAttribute(transactionAttribute);

        return new TransactionInterceptor(mainTransactionManager, attributeSource);
    }

    @Bean
    public Advisor mainTransactionAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(EXPRESSION);

        return new DefaultPointcutAdvisor(pointcut, mainTransactionAdvice());
    }
}
