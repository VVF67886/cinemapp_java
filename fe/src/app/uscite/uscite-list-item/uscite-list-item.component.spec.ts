import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsciteListItemComponent } from './uscite-list-item.component';

describe('UsciteListItemComponent', () => {
  let component: UsciteListItemComponent;
  let fixture: ComponentFixture<UsciteListItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UsciteListItemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsciteListItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
