package kitchenpos.menu.service;

import kitchenpos.menu.domain.MenuGroup;
import kitchenpos.menu.domain.MenuGroupRepository;
import kitchenpos.menu.dto.MenuGroupRequest;
import kitchenpos.menu.dto.MenuGroupResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class MenuGroupService {
    private final MenuGroupRepository menuGroupRepository;

    public MenuGroupService(MenuGroupRepository menuGroupRepository) {
        this.menuGroupRepository = menuGroupRepository;
    }

    public MenuGroupResponse create(final MenuGroupRequest menuGroupRequest) {
        final MenuGroup savedGroup = menuGroupRepository.save(menuGroupRequest.toGroup());
        return MenuGroupResponse.of(savedGroup);
    }

    @Transactional(readOnly = true)
    public MenuGroup findById(long id) {
        return menuGroupRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("메뉴 그룹을 찾을수 없습니다."));
    }

    @Transactional(readOnly = true)
    public List<MenuGroupResponse> list() {
        return menuGroupRepository
                .findAll()
                .stream()
                .map(MenuGroupResponse::of)
                .collect(Collectors.toList());
    }
}
