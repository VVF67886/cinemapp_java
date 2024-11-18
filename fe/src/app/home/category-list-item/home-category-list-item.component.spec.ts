import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeCategoryListItemComponent } from './home-category-list-item.component';

describe('HomeCategoryListItemComponent', () => {
  let component: HomeCategoryListItemComponent;
  let fixture: ComponentFixture<HomeCategoryListItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeCategoryListItemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeCategoryListItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
