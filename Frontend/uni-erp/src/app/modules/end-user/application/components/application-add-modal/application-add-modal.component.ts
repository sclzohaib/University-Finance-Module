import { Component, OnInit } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd';

@Component({
  selector: 'app-application-add-modal',
  templateUrl: './application-add-modal.component.html',
  styleUrls: ['./application-add-modal.component.less']
})
export class ApplicationAddModalComponent implements OnInit {

  constructor(private modalRef: NzModalRef<ApplicationAddModalComponent>) { }

  ngOnInit() {
  }

  onCancel() {
    this.modalRef.triggerCancel();
  }

}
