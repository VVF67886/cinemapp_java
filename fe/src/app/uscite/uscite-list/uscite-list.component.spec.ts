import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsciteListComponent } from './uscite-list.component';

describe('UsciteListComponent', () => {
  let component: UsciteListComponent;
  let fixture: ComponentFixture<UsciteListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UsciteListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UsciteListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
