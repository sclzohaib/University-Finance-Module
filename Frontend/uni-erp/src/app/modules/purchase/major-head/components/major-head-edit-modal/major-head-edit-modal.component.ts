import { MajorHeadService } from './../../../../../core/services/Purchase/major-head.service';
import { MajorHead } from './../../../../../core/models/Purchase/major-head';
import { Component, OnInit, Input } from '@angular/core';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-major-head-edit-modal',
  templateUrl: './major-head-edit-modal.component.html',
  styleUrls: ['./major-head-edit-modal.component.less']
})
export class MajorHeadEditModalComponent implements OnInit {

	@Input() majorHd: MajorHead;
  constructor(private majorHeadService: MajorHeadService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService) { }

  ngOnInit() {
	}

	onCancel() {
		this.modalRef.triggerCancel();
	}

	updateMajorHead(){
		this.majorHeadService.updateMajorHead(this.majorHd.id, this.majorHd).subscribe(
			data => {
				this.message.create('success', `Major Head Updated Successfully!`,{nzDuration:3000});
				// console.log(JSON.parse(JSON.stringify(this.authLvl)))
				this.modalRef.triggerOk();
			},
			error => {
				this.message.create('error', `Major Head Not Updated!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();
	}

}
