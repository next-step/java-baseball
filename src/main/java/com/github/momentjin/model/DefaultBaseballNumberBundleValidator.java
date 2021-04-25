package com.github.momentjin.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultBaseballNumberBundleValidator implements BaseballNumberBundleValidator {

    @Override
    public void validate(BaseballNumberBundle bundle) throws BaseballNumberDomainException {

        validateSize(bundle);
        validateOverLap(bundle);
    }

    private void validateSize(BaseballNumberBundle bundle) {

        if (bundle.size() == BaseballNumberConstants.BUNDLE_SIZE) {
            return;
        }

        throw new BaseballNumberDomainException(
            String.format("숫자야구게임의 숫자 묶음 사이즈는 %d이어야 합니다.", BaseballNumberConstants.BUNDLE_SIZE)
        );
    }

    private void validateOverLap(BaseballNumberBundle bundle) {

        List<BaseballNumber> baseballNumberList = bundle.getBaseballNumbers();
        Set<BaseballNumber> baseballNumberSet = new HashSet<>(baseballNumberList);

        if (baseballNumberSet.size() != bundle.size()) {
            throw new BaseballNumberDomainException("숫자야구게임의 숫자 묶음은 중복을 허용하지 않습니다.");
        }
    }
}