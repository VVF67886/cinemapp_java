import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeCategoryListComponent } from './home-category-list.component';

describe('HomeCategoryListComponent', () => {
  let component: HomeCategoryListComponent;
  let fixture: ComponentFixture<HomeCategoryListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HomeCategoryListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeCategoryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
