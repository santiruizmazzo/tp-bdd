import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GastoNuevoComponent } from './gasto-nuevo.component';

describe('GastoNuevoComponent', () => {
  let component: GastoNuevoComponent;
  let fixture: ComponentFixture<GastoNuevoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GastoNuevoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GastoNuevoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
